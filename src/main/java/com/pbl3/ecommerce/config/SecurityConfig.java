package com.pbl3.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
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
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(authorize -> authorize
                        // Cho phép truy cập công khai đến các resources và các trang không cần bảo vệ
                        .requestMatchers(
                                "/api/auth/**",
                                "/css/**", "/js/**", "/images/**", "/webjars/**",
                                "/", "/index", "/index.html",
                                "/register", "/register.html",
                                "/login", "/login.html",
                                "/accessDenied", "/accessDenied.html"
                        ).permitAll()
                        // Các request khác yêu cầu xác thực
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .loginProcessingUrl("/api/auth/login") // URL xử lý form đăng nhập
                        .defaultSuccessUrl("/", true) // Trang chuyển hướng sau khi đăng nhập thành công
                        .failureUrl("/login?error=true") // Trang chuyển hướng nếu đăng nhập thất bại
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/api/auth/logout") // URL xử lý đăng xuất
                        .logoutSuccessUrl("/") // Trang chuyển hướng sau khi đăng xuất
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    @Primary
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}