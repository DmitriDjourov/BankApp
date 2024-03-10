package com.djourov.bankapp.config;

import com.djourov.bankapp.service.impl.ManagerDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final ManagerDetailsServiceImpl managerDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(managerDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> auth
                                                      .requestMatchers("/app/account/accounts").hasRole("USER")//localhost:8080/app/account/accounts
                                                      .requestMatchers("/app/account/account_client_manager/{id}").hasRole("USER")//localhost:8080/app/account/account_client_manager/91384699-c928-11ee-87e5-00155d26ef58
                                                      .requestMatchers("/app/account/{id}").hasRole("USER")//localhost:8080/app/account/91384699-c928-11ee-87e5-00155d26ef58
                                                      .requestMatchers("/app/account/account_number/{id}").hasRole("USER")//localhost:8080/app/account/account_number/123456789
                                                      .requestMatchers("/app/agreement/agreements").hasRole("ADMIN")//localhost:8080/app/agreement/agreements
                                                      .requestMatchers("/app/client/clients").hasRole("ADMIN")//localhost:8080/app/client/clients
                                                      .requestMatchers("/app/client/{id}").hasRole("ADMIN")//localhost:8080/app/client/91331a7e-c928-11ee-87e5-00155d26ef58
                                                      .requestMatchers("/app/client/active/{status}").hasRole("ADMIN")//localhost:8080/app/client/active/0
                                                      .requestMatchers("/app/manager/managers").hasRole("ADMIN")//localhost:8080/app/manager/managers
                                                      .requestMatchers("/app/manager/first_last_name/{id}").hasRole("ADMIN")//localhost:8080/app/manager/first_last_name/912f26ae-c928-11ee-87e5-00155d26ef58
                                                      .requestMatchers("/app/manager/{id}").hasRole("ADMIN")// localhost:8080/app/manager/b407a7f7-b49f-11ee-9c53-00ffe0e1a544?format=json(xml)
                                                      .requestMatchers("/app/manager/createManager").hasRole("ADMIN")// localhost:8080/app/manager/createManager
                                                      .requestMatchers("/app/manager/del/{id}").hasRole("ADMIN")// localhost:8080/app/manager/del/
                                                      .requestMatchers("/app/manager/upd/manager_status_senior/{id}").hasRole("ADMIN")//localhost:8080/app/manager/upd/manager_status_senior/
                                                      .requestMatchers("/pages/manager/managers").hasRole("ADMIN")// localhost:8080/pages/manager/managers
                                                      .requestMatchers("/pages/manager/{id}").hasRole("ADMIN")// localhost:8080/pages/manager/912f26ae-c928-11ee-87e5-00155d26ef58
                                                      .requestMatchers("/app/product/{id}").hasRole("ADMIN")//localhost:8080/app/product/9131da8a-c928-11ee-87e5-00155d26ef58
                                                      .requestMatchers("/app/product/products").hasRole("ADMIN")// localhost:8080/app/product/products
                                                      .requestMatchers("/app/product/create").hasRole("ADMIN")// localhost:8080/app/product/create
                                                      .requestMatchers("/app/transaction/transactions").hasRole("ADMIN")//localhost:8080/app/transaction/transactions
                       )
                       .formLogin(Customizer.withDefaults())
                       .logout(logoutPage -> logoutPage.logoutSuccessUrl("/"))
                       .build();
    }

    //Если создавать юзеров прямо в памяти
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user = User.builder()
//                                   .passwordEncoder(new BCryptPasswordEncoder()::encode)
//                                   .username("user")
//                                   .password("user")//{bcrypt}
//                                   .roles("USER")
//                                   .build();
//        UserDetails admin = User.builder()
//                                    .passwordEncoder(new BCryptPasswordEncoder()::encode)
//                                    .username("admin")
//                                    .password("admin")//{bcrypt}
//                                    .authorities("READ_SECRET")
//                                    .roles("ADMIN", "USER")
//                                    .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}
