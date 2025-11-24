package com.example.core.demo.service;

import com.example.core.demo.integration.VisaPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private VisaPayment visapayment;

    @Autowired
    public OrderService (VisaPayment visapayment){
        this.visapayment = visapayment;
    }
    public void datHang(String sanPham, double giaTien) {
        System.out.println("Đang đặt món: " + sanPham);
        visapayment.processPayment(giaTien);
    }
}
