package com.example.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data// getter,setter,hashcode,tostring,equals,..
@NoArgsConstructor//contructor khong tham so
@AllArgsConstructor//contructor co tham so
public class Student {
    private Long id;
    private String name;
    private String email;
    private int age;
}
