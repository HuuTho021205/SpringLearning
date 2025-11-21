package com.example.corespring.demo.service;

import com.example.corespring.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public void addStudent(String name){
        if (name == null || name.trim().isEmpty()){
            System.out.println("Lỗi: Tên không được rỗng");
            return;
        }
        String cleanName = name.trim().replaceAll("\\s+"," ").toUpperCase();
        System.out.println("Server đã xử lí xong tên: " + cleanName + ". Đang chuyển xuống kho");
        studentRepository.save(cleanName);
    }
    public List<String> getAllStudents(){
        return studentRepository.findAll();
    }

}
