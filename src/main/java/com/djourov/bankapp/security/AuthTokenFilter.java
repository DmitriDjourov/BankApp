package com.djourov.bankapp.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final ManagerDetailsServiceImpl managerDetailsService;
    private static final String BEARER = "Authorization=Bearer";

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) {
        String jwt = parseJwt(request);
        if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
            String userName = jwtUtils.getBody(jwt).getSubject(); // get userName
            UserDetails userDetails = managerDetailsService.loadUserByUsername(userName);
            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            try {
                filterChain.doFilter(request, response);
            } catch (IOException | ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String parseJwt(HttpServletRequest request) {
        String getHeader = request.getHeader("cookie");
        if (getHeader.startsWith(BEARER)) {
            int index = getHeader.contains(";") ? getHeader.indexOf(";") : getHeader.length();
            return getHeader.substring(BEARER.length(), index);
        }
        return null;
    }
}
