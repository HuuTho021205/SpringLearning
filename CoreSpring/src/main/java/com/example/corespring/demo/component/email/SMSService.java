package com.example.corespring.demo.component.email;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary// ưu tiên mặc định nghĩa là nếu k ai yêu cầu gì thì sẽ dùng cái nào có primary
public class SMSService implements MessageService {
    @Override
    public void sendMessage(String mesage){
        System.out.println("SMS Server đang gửi: " + mesage);
    }
}
