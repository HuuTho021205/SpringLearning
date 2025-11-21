package com.example.corespring.luyentap;

import org.springframework.stereotype.Component;

@Component
public class Momo implements PaymentMethod{
    @Override
    public void pay(){
        System.out.println("Thanh toán bằng MoMo");
    }
}
