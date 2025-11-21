package com.example.corespring.luyentap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {

    @Bean
    public EmailServer emailServer(){
        return new EmailServer();
    }
}
