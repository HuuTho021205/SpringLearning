package com.example.todo.controllertodo;

import com.example.todo.dto.LoginDTO;
import com.example.todo.dto.RegisterDTO;
import com.example.todo.entity.User;
import com.example.todo.servicetodo.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register (@Valid @RequestBody RegisterDTO request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO request){
        return ResponseEntity.ok(authService.login(request));
    }
}
