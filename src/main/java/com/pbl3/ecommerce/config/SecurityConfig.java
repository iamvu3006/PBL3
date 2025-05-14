package com.pbl3.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.http.HttpStatus;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ❌ Tắt CSRF vì dùng API
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // ✅ Cho phép CORS nếu dùng Postman / frontend
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/auth/**", // ✅ Mở các API login, register, logout
                                "/css/**", "/js/**", "/images/**", "/webjars/**",
                                "/", "/index", "/index.html",
                                "/login", "/login.html",
                                "/register", "/register.html"
                        ).permitAll()
                        .anyRequest().authenticated() // ✅ Các request khác phải đăng nhập
                )
                .formLogin(form -> form.disable()) // ❌ Tắt form login để không override login API
                .httpBasic(httpBasic -> httpBasic.disable()) // ❌ Không dùng Basic Auth
                .logout(logout -> logout.disable()) // ❌ Không dùng logout mặc định
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)) // ✅ Trả 401 nếu chưa đăng nhập
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("*")); // ⚠ Có thể chỉnh sửa cho production
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        config.setAllowCredentials(true); // Nếu bạn dùng session/cookie

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    @Primary
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
