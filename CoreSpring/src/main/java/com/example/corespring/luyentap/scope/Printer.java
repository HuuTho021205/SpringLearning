package com.example.corespring.luyentap.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Printer {
    private final ApplicationContext context;

    @Autowired
    public Printer(ApplicationContext context){
        this.context = context;
    }

    public void printCustomerTicket(){
        System.out.println("Máy in đang hoạt động");
        Ticket ticket = context.getBean(Ticket.class);

        ticket.printTicketNumber();
    }
}
