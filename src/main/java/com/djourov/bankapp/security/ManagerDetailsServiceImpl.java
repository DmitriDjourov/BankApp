package com.djourov.bankapp.security;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.entity.Role;
import com.djourov.bankapp.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
@RequiredArgsConstructor
public class ManagerDetailsServiceImpl implements UserDetailsService {

    public final ManagerRepository managerRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String managerName) throws UsernameNotFoundException {
        Manager manager = managerRepository.findByLastName(managerName);
        if (manager == null) {
            throw new UsernameNotFoundException("User with login '" + managerName + "' not found");
        }

        return withUsername(managerName)
                       .username(manager.getLastName())
                       .password(manager.getPassword())
                       .authorities(getAuthorities(manager.getRoles()))
                       .build();
    }


    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> collection) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Добавляем роли в список authorities
        for (Role role : collection) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));

            // Добавляем права доступа (authorities) связанные с каждой ролью
            role.getAuthorities().forEach(authority ->
                                                  authorities.add(new SimpleGrantedAuthority(authority.getAuthority()))
            );
        }

        return authorities;
    }
}