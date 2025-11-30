package com.example.todo.config;

import com.example.todo.servicetodo.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//    khai báo bean mã hóa mật khẩu
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                // khu vực công cộng : đăng nhập/ đăng kí ai cũng vào được
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**").permitAll()
//                        khu vực cấm : tất cả các vé api còn lại phải có vé (authenticated) mới được vào
                        .anyRequest().authenticated())
        // chèn máy quét thẻ(jwtAuthenticationFilter) vào trước
//        cái máy kiểm tra Username/password mặc định
//        nghĩa là kiểm tra thẻ trước, nếu có thẻ thì cho qua luôn, không hỏi pass
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
