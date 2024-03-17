package com.djourov.bankapp.config;

import com.djourov.bankapp.security.JwtAuthenticationFilter;
import com.djourov.bankapp.security.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserService userService;


    private static final String[] SWAGGER_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-resources",
            "/swagger-ui/",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/webjars/**",
            "/configuration/**",
            "/configuration/ui",
            "/configuration/security",
            "/public",
            "/favicon.ico",
            "/h2-console/**",
            "/conferenc/v1/swagger-ui.html",
            "/swagger-resources/configuration/ui",
            "/swagger-resources/configuration/security",
            "/",
            "/login", "/logout",
            "/csrf"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .cors(cors -> cors.configurationSource(request -> {
//                    var corsConfiguration = new CorsConfiguration();
//                    corsConfiguration.setAllowedOriginPatterns(List.of("*"));
//                    corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//                    corsConfiguration.setAllowedHeaders(List.of("*"));
//                    corsConfiguration.setAllowCredentials(true);
//                    return corsConfiguration;
//                }))
                .cors(AbstractHttpConfigurer::disable)//
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(a -> a
                                                    //.requestMatchers("/swagger*/**", "/configuration/**", "/v2/api-docs", "/webjars/**").permitAll()
                                                    .requestMatchers(SWAGGER_LIST).permitAll()
                                                    .requestMatchers("/app/account/accounts").hasRole("ADMIN")//localhost:8080/app/account/accounts
                                                    .requestMatchers("/app/account/account_client_manager/{id}").permitAll()//.hasRole("USER")//localhost:8080/app/account/account_client_manager/91384699-c928-11ee-87e5-00155d26ef58
                                                    .requestMatchers("/app/account/{id}").permitAll()//.hasRole("USER")//localhost:8080/app/account/91384699-c928-11ee-87e5-00155d26ef58
                                                    .requestMatchers("/app/account/account_number/{id}").permitAll()//.hasRole("USER")//localhost:8080/app/account/account_number/123456789
                                                    .requestMatchers("/app/agreement/agreements").permitAll()//.hasRole("ADMIN")//localhost:8080/app/agreement/agreements
                                                    .requestMatchers("/app/client/clients").permitAll()//.hasRole("ADMIN")//localhost:8080/app/client/clients
                                                    .requestMatchers("/app/client/{id}").permitAll()//.hasRole("ADMIN")//localhost:8080/app/client/91331a7e-c928-11ee-87e5-00155d26ef58
                                                    .requestMatchers("/app/client/active/{status}").permitAll()//.hasRole("ADMIN")//localhost:8080/app/client/active/0
                                                    .requestMatchers("/app/manager/managers").permitAll()//.hasRole("ADMIN")//localhost:8080/app/manager/managers
                                                    .requestMatchers("/app/manager/first_last_name/{id}").permitAll()//.hasRole("ADMIN")//localhost:8080/app/manager/first_last_name/912f26ae-c928-11ee-87e5-00155d26ef58
                                                    .requestMatchers("/app/manager/{id}").permitAll()//hasRole("ADMIN")// localhost:8080/app/manager/b407a7f7-b49f-11ee-9c53-00ffe0e1a544?format=json(xml)
                                                    .requestMatchers("/app/manager/createManager").permitAll()//.hasRole("ADMIN")// localhost:8080/app/manager/createManager
                                                    .requestMatchers("/app/manager/del/{id}").permitAll()//.hasRole("ADMIN")// localhost:8080/app/manager/del/
                                                    .requestMatchers("/app/manager/upd/manager_status_senior/{id}").permitAll()//.hasRole("ADMIN")//localhost:8080/app/manager/upd/manager_status_senior/
                                                    .requestMatchers("/pages/manager/managers").permitAll()//.hasRole("ADMIN")// localhost:8080/pages/manager/managers
                                                    .requestMatchers("/pages/manager/{id}").permitAll()//.hasRole("ADMIN")// localhost:8080/pages/manager/912f26ae-c928-11ee-87e5-00155d26ef58
                                                    .requestMatchers("/app/product/{id}").permitAll()//.hasRole("ADMIN")//localhost:8080/app/product/9131da8a-c928-11ee-87e5-00155d26ef58
                                                    .requestMatchers("/app/product/products").permitAll()//.hasRole("ADMIN")// localhost:8080/app/product/products
                                                    .requestMatchers("/app/product/create").permitAll()//.hasRole("ADMIN")// localhost:8080/app/product/create
                                                    .requestMatchers("/app/transaction/transactions").permitAll()//.hasRole("ADMIN")//localhost:8080/app/transaction/transactions
                                                    //.requestMatchers(HttpMethod.POST).permitAll()
                                                    .anyRequest().authenticated())
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .logout(logoutPage -> logoutPage.logoutSuccessUrl("/"))
                .sessionManagement(sessionManagement ->
                                           sessionManagement
                                                   .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();


//                // Настройка доступа к конечным точкам
//                .authorizeHttpRequests(request -> request
//                        // Можно указать конкретный путь, * - 1 уровень вложенности, ** - любое количество уровней вложенности
//                        .requestMatchers("/auth/**").permitAll()
//                        .requestMatchers("/swagger-ui/**", "/swagger-resources/*", "/v3/api-docs/**").permitAll()
//                        .requestMatchers("/endpoint", "/admin/**").hasRole("ADMIN")
//                        .anyRequest().authenticated())
//                .sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS))
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }
}

//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                       .authorizeHttpRequests(auth ->
//                                                      auth
//                                                              .requestMatchers("/app/account/accounts").hasRole("USER")//localhost:8080/app/account/accounts
//                                                              .requestMatchers("/app/account/account_client_manager/{id}").hasRole("USER")//localhost:8080/app/account/account_client_manager/91384699-c928-11ee-87e5-00155d26ef58
//                                                              .requestMatchers("/app/account/{id}").hasRole("USER")//localhost:8080/app/account/91384699-c928-11ee-87e5-00155d26ef58
//                                                              .requestMatchers("/app/account/account_number/{id}").hasRole("USER")//localhost:8080/app/account/account_number/123456789
//
//                                                              .requestMatchers("/app/agreement/agreements").hasRole("ADMIN")//localhost:8080/app/agreement/agreements
//
//                                                              .requestMatchers("/app/client/clients").hasRole("ADMIN")//localhost:8080/app/client/clients
//                                                              .requestMatchers("/app/client/{id}").hasRole("ADMIN")//localhost:8080/app/client/91331a7e-c928-11ee-87e5-00155d26ef58
//                                                              .requestMatchers("/app/client/active/{status}").hasRole("ADMIN")//localhost:8080/app/client/active/0
//
//                                                              .requestMatchers("/app/manager/managers").hasRole("ADMIN")//localhost:8080/app/manager/managers
//                                                              .requestMatchers("/app/manager/first_last_name/{id}").hasRole("ADMIN")//localhost:8080/app/manager/first_last_name/912f26ae-c928-11ee-87e5-00155d26ef58
//                                                              .requestMatchers("/app/manager/{id}").hasRole("ADMIN")// localhost:8080/app/manager/b407a7f7-b49f-11ee-9c53-00ffe0e1a544?format=json(xml)
//                                                              .requestMatchers("/app/manager/createManager").hasRole("ADMIN")// localhost:8080/app/manager/createManager
//                                                              .requestMatchers("/app/manager/del/{id}").hasRole("ADMIN")// localhost:8080/app/manager/del/
//                                                              .requestMatchers("/app/manager/upd/manager_status_senior/{id}").hasRole("ADMIN")//localhost:8080/app/manager/upd/manager_status_senior/
//                                                              .requestMatchers("/pages/manager/managers").hasRole("ADMIN")// localhost:8080/pages/manager/managers
//                                                              .requestMatchers("/pages/manager/{id}").hasRole("ADMIN")// localhost:8080/pages/manager/912f26ae-c928-11ee-87e5-00155d26ef58
//
//                                                              .requestMatchers("/app/product/{id}").hasRole("ADMIN")//localhost:8080/app/product/9131da8a-c928-11ee-87e5-00155d26ef58
//                                                              .requestMatchers("/app/product/products").hasRole("ADMIN")// localhost:8080/app/product/products
//                                                              .requestMatchers("/app/product/create").hasRole("ADMIN")// localhost:8080/app/product/create
//
//                                                              .requestMatchers("/app/transaction/transactions").hasRole("ADMIN")//localhost:8080/app/transaction/transactions
//                                                             // .requestMatchers("/app/transaction/transactions").hasAuthority("READ_SECRET")
//                                                              )
//                       .formLogin(Customizer.withDefaults())
//                       .logout(logoutPage -> logoutPage.logoutSuccessUrl("/"))
//                       .build();
//    }
//
//    //Если создавать юзеров прям в памяти
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
//                                    .roles("ADMIN", "USER")
//                                    .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//}
