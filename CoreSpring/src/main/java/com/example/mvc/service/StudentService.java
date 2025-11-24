package com.example.mvc.service;

import com.example.mvc.model.Student;
import com.example.mvc.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentServiceMVC")
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Student add(Student student){
        return studentRepository.save(student);
    }

    public Student update(Long id, Student newInfo){
        for (Student s : studentRepository.findAll()){
            if (s.getId().equals(id)){
                s.setName(newInfo.getName());
                s.setAge(newInfo.getAge());
                s.setEmail(newInfo.getEmail());
                return s;
            }
        }
        return null;
    }

    public void detete(Long id){
        studentRepository.findAll().removeIf(student -> student.getId().equals(id));
    }
}
