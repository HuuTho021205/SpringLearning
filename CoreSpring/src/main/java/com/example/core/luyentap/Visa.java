package com.example.core.luyentap;

import org.springframework.stereotype.Component;

@Component
public class Visa implements PaymentMethod {
    @Override
    public void pay(){
        System.out.println("Thanh toán bằng Visa");
    }
}
