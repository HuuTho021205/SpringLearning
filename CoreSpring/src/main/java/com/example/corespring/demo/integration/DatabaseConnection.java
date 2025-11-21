package com.example.corespring.demo.integration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection {
    public DatabaseConnection(){
        System.out.println("1. Constructor: Đang tạo vỏ bean...");
    }

    @PostConstruct
    public void connect(){
        System.out.println("2. @PostConstruct: Đang mở kết nối Database...");
        System.out.println("Đã sẵn sàng chạy");
    }

    @PreDestroy
    public void disconnect(){
        System.out.println("3. @PreDestroy: Đang đóng kết nối Database...");
        System.out.println("  => ĐÃ NGẮT KẾT NỐI");
    }

    public void queryData(){
        System.out.println("Đang lấy dữ liệu từ DB...");
    }
}
