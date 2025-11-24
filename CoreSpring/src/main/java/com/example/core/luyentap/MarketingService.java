package com.example.core.luyentap;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketingService {
    private final EmailServer emailServer;

    @PostConstruct
    public void connect(){
        emailServer.connect();
    }

    public void sendEmail(String email){
        System.out.println("Đang gửi email quảng cáo tới: " + email);
    }
}
