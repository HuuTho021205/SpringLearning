package com.example.corespring.Demo.sendNotification;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message){
        System.out.println("Email Server đang gửi: " + message);
    }
}
