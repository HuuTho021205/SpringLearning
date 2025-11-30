package com.example.todo.servicetodo;

import com.example.todo.security.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
// kế thừa OncePerRequestFilter : đảm bảo bộ lọc này chỉ chạy 1 lần cho mỗi request
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenProvider tokenProvider;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
    // lấy chuỗi token từ header của request gửi lên
    String token = getTokenFromRequest(request);
        System.out.println("---------------------------------------------");
        System.out.println("🔍 [FILTER] 1. Token nhận được từ Header: " + token);
    // nếu có token và token hợp lệ
    if (StringUtils.hasText(token) && tokenProvider.validateToken(token)){
        System.out.println("✅ [FILTER] 2. Token HỢP LỆ! Bắt đầu lấy thông tin User...");
        // lấy username từ trong token ra
        String username = tokenProvider.getUsernameFromToken(token);
        System.out.println("👤 [FILTER] 3. Username trong token là: " + username);
//        lấy thông tin chi tiết từ db( như pass, role, user)
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

//        tạo vé thông hành chứng nhận user đã được xác thực và đây là thông tin của nó

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

//        gắn thêm thông tin chi tiết của resquest
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

//        đưa vé cho bảo vệ giữ (SecurityContextHolder)
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("🔓 [FILTER] 4. Đã xác thực thành công! Cho phép đi qua.");
        }
    else {
        // Nếu code chạy vào đây nghĩa là Token sai hoặc hết hạn
        System.out.println("❌ [FILTER] 2. Token KHÔNG HỢP LỆ hoặc RỖNG!");
    }
        // --- KẾT THÚC DEBUG ---
//    cho phép request đi tiếp vào các bộ lọc sau ( hoặc vào controller)
    filterChain.doFilter(request,response);

    }
    // hàm lấy token từ header"Authorization"
    private String getTokenFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        // kiểm tra xem header có bắt đầu bằng chữ bearer không
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);// cắt bỏ bearer để lấy phần mã phía sau
            }
        return null;
    }


}
