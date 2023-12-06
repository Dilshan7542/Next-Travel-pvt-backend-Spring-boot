package lk.travel.authservice.security;

import jakarta.servlet.http.HttpServletRequest;


import lk.travel.authservice.filter.JwtGenerateFilter;
import lk.travel.authservice.filter.JwtValidateFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors(httpCors -> {
                    httpCors.configurationSource(new CorsConfigurationSource() {
                        @Override
                        public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                            CorsConfiguration corsConfiguration = new CorsConfiguration();
                            corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:63342"));
                            corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
                            corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
                            corsConfiguration.setAllowCredentials(true);
                            corsConfiguration.setExposedHeaders(Arrays.asList(HttpHeaders.AUTHORIZATION));
                            corsConfiguration.setMaxAge(3600L);
                            return corsConfiguration;

                        }
                    });
                }).sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                }).csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(new JwtValidateFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JwtGenerateFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(request -> {
                    request
                            .requestMatchers("/api/v1/customer/register","/api/v1/vehicle/brand/search/**","/api/v1/hotel/search/**").permitAll()
                            .requestMatchers("api/v1/user/register","api/v1/user/update").hasRole("MANAGER")
                            .requestMatchers("api/v1/customer/update","api/v1/customer/search/**").hasAnyRole("USER")
                            .requestMatchers("api/v1/travel/**","api/v1/booking/**").hasAnyRole("MANAGER","ADMIN","USER")
                            .requestMatchers("api/v1/**").hasAnyRole("MANAGER","ADMIN")
                            .anyRequest().authenticated();

                });
        httpSecurity.httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
