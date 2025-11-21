package com.example.corespring.luyentap;

import org.springframework.stereotype.Component;

@Component
public class ZaloPay implements PaymentMethod{
    @Override
    public void pay(){
        System.out.println("Thanh toán bằng ZaloPay");
    }
}
