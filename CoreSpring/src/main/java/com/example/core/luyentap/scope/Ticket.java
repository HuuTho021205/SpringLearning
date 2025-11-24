package com.example.core.luyentap.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Ticket {
    public Ticket(){
        System.out.println("Một tờ vé số mới được in ra");
    }
    public void printTicketNumber(){
        System.out.println("Mã vé: " + this.toString());
    }
}
