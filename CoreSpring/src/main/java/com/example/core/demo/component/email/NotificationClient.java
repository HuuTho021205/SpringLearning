package com.example.core.demo.component.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationClient {
    private final MessageService messageService;
    @Autowired
    // @Qualifier gán cứng cho bean muốn xài ở đây là EmailService mạnh hơn @Primary
    // @Qualifier("tên_bean") tên bean mặc định là tên của class mà viết thường chữ đầu tiên
    public NotificationClient(@Qualifier("emailService") MessageService messageService){
        this.messageService = messageService;
    }

    public void sendNotification(String message){
        messageService.sendMessage(message);
    }
}
