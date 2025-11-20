package com.example.corespring.Demo.Warrior;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Gun implements Weapon {
    @Override
    public void attack(){
        System.out.println("Súng bắn: Pằng Pằng");
    }
}
