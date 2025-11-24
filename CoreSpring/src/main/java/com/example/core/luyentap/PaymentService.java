package com.example.core.luyentap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final List<PaymentMethod> paymentMethods;

    @Autowired
    public PaymentService(List<PaymentMethod> paymentMethods){
        this.paymentMethods =paymentMethods;
    }

    public void payAll(){
        System.out.println("----------Bắt Đầu Thanh Toán Toàn Bộ---------------");
        for (PaymentMethod a : paymentMethods){
            a.pay();
        }
        System.out.println("-----------Kết thúc------------");
    }
}
