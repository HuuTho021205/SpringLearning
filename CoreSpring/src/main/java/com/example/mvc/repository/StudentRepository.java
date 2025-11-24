package com.example.mvc.repository;

import com.example.mvc.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("studentRepoMVC")// đặt tên cho bean
public class StudentRepository {
    private List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void init(){
        studentList.add(new Student(1L, "Trần Đình Hữu Thọ", "a@gmail.com", 20));
        studentList.add(new Student(2L, "Hữu Thọ", "b@gmail.com", 20));
        System.out.println("Đã tạo dữ liệu mẫu: " + studentList.size() + " Sinh viên.");
    }

    public List<Student> findAll(){
        return studentList;
    }

    public Student save (Student student){
        studentList.add(student);
        return student;
    }
}
