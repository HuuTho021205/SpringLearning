package com.example.corespring.demo.component.warrior;

import org.springframework.stereotype.Component;

@Component
public class Gun implements Weapon {
    @Override
    public void attack(){
        System.out.println("Súng bắn: Pằng Pằng");
    }
}
