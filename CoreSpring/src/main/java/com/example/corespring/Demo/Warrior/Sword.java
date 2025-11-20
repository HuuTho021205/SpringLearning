package com.example.corespring.Demo.Warrior;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Sword implements Weapon {
    @Override
    public void attack(){
        System.out.println("Vung kiếm tấn công ");
    }
}
