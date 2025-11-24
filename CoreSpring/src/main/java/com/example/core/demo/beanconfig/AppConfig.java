package com.example.core.demo.beanconfig;

import com.example.core.demo.integration.VisaPayment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public VisaPayment visaPayment(){
        return new VisaPayment();
    }
}
