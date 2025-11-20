package com.example.corespring.Demo.Warrior;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Warrior {
    private final Weapon weapon;

    @Autowired
    public Warrior(@Qualifier("gun") Weapon weapon){
        this.weapon = weapon;
    }

    public void fight(){
        System.out.println("Chiến binh dùng vũ khí tấn công");
        weapon.attack();
    }
}