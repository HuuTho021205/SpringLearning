package com.example.core.luyentap;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class SmartBulb {
    private final String color;
    private final int birghtness;

    public SmartBulb( @Value("${smart.home.bulb.color}") String color, @Value("${smart.home.bulb.brightness}") int birghtness){
        this.color = color;
        this.birghtness = birghtness;
    }
    @PostConstruct
    public void turnOn(){
        System.out.println("----------------------------");
        System.out.println("SmartBulb Đang khởi động");
        System.out.println("Màu sắc cài đặt: " + color);
        System.out.println("Độ sáng cài đặt: " + birghtness);
        System.out.println("------------------------------");
    }
}
