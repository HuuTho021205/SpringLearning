package com.example.corespring.demo.beanconfig;

import com.example.corespring.demo.integration.VisaPayment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public VisaPayment visaPayment(){
        return new VisaPayment();
    }
}
