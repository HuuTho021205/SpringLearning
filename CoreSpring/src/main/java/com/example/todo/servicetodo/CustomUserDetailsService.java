package com.example.todo.servicetodo;

import com.example.todo.entity.User;
import com.example.todo.repotodo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        // tìm user trong db
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("Không tìm thấy username" + username));
        // chuyển đổi sang chuẩn UserDetails của Spring sercurity
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
