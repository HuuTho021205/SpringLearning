package com.example.core.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<String> database = new ArrayList<>();

    public void save(String name){
        database.add(name);
        System.out.println("(kho) Đã lưu vào danh sách: " + name);
    }

    public List<String> findAll(){
        return database;
    }
}
