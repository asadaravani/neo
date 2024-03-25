//package org.example.onlineshop.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import static org.springframework.security.config.Customizer.withDefaults;
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder.encode("password"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("USER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers("/api/user/register", "/api/user/login").permitAll()
//                        .anyRequest().authenticated()
//                )
//                //.sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
//                .httpBasic(withDefaults());
//        System.out.println("here");
//        return http.build();
//    }
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .csrf(AbstractHttpConfigurer::disable)
////                .authorizeHttpRequests(req ->
////                        req.requestMatchers(WHITE_LIST_URL)
////                                .permitAll()
////                                .requestMatchers(POST, "/api/user/register").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
////                                .requestMatchers(POST, "/api/user/login").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
////                                .anyRequest()
////                                .authenticated()
////                )
////                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
////                .authenticationProvider(authenticationProvider)
////                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
////                .logout(logout ->
////                        logout.logoutUrl("/api/v1/auth/logout")
////                                .addLogoutHandler(logoutHandler)
////                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
////                )
////        ;
////
////        return http.build();
////    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//
//}
