package com.djourov.bankapp.security;

import com.djourov.bankapp.dto.SignInRequest;
import com.djourov.bankapp.dto.SignUpRequest;
import com.djourov.bankapp.entity.User;
import com.djourov.bankapp.entity.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    // Регистрация пользователя
    public JwtAuthenticationResponse signUp(SignUpRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);

        userService.create(user);

        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);

//        User user = User.builder()
//                .login(request.getUsername())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(Role.ROLE_USER)
//                .build();
//
//        userService.create(user)
//;
//        String jwt = jwtService.generateToken(user);
//        return new JwtAuthenticationResponse(jwt);
    }

    // Аутентификация пользователя
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        UserDetails user = userService
                                   .userDetailsService()
                                   .loadUserByUsername(request.getUsername());

        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}
