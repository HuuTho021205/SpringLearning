package com.example.todo.servicetodo;


import com.example.todo.dto.LoginDTO;
import com.example.todo.dto.RegisterDTO;
import com.example.todo.entity.User;
import com.example.todo.repotodo.UserRepository;
import com.example.todo.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public User register(RegisterDTO request){
        if (userRepository.findByUsername(request.getUsername()).isPresent()){
            throw new RuntimeException("Tài khoản này đã tồn tại");
        }

        User newUser = new User();
        newUser.setUsername(request.getUsername());
//        mã hóa password
        String encoderPassword = passwordEncoder.encode(request.getPassword());
        newUser.setPassword(encoderPassword);

        newUser.setRole("USER");
        return userRepository.save(newUser);
    }

    public String login (LoginDTO request){
//        kiểm tra tài khoản đã có trong db chưa
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(()->new RuntimeException("Tài khoản không tồn tại"));

//        Kiểm tra mật khẩu có đúng không
//        mật khẩu thô của khách nhập và mật khẩu mã hóa trong db
        if (! passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Mật khẩu không đúng");
        }

        // nếu ok thì cấp token
        return jwtTokenProvider.generateToken(user.getUsername());
    }
}
