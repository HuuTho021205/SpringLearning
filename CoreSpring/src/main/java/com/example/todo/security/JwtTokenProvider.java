package com.example.todo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {
//    tạo chìa khóa bí mật
    // thực tế sẽ để trong properties
    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // thời gian hết hạn
    private final long JWT_EXPIRATION = 8640000L;

    // tạo token
    public String generateToken(String username){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

//        tạo chuôi jwt từ username
        return Jwts.builder()
                .setSubject(username) // ghi tên người dùng vào token
                .setIssuedAt(now) // ghi ngày cấp
                .setExpiration(expiryDate) // ghi ngày hết hạn
                .signWith(secretKey) // gắn chìa khóa lên
                .compact();
    }
    // Lấy username trong token ra
    public String getUsernameFromToken(String token){
        // parser để phân tích token
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)// dùng chìa khóa để mở
                .build()
                .parseClaimsJws(token)// giải mã
                .getBody()// lấy phần nhân
                .getSubject();// lấy cái tên đã lưu lúc nãy
    }
    // kiểm tra thẻ
    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        }
        catch (Exception e){
            // nếu token hết hạn, sai hoặc bị sửa đổi ném ra lỗi
            System.out.println("🔥 LỖI VALIDATE: " + e.getClass().getName() + " - " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
