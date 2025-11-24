package com.example.mvc.controller;

import com.example.mvc.model.Student;
import com.example.mvc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getList(){
        System.out.println("Có khách đang xem danh sách sinh viên");
        return studentService.getAll();
    }

    @PostMapping
    public Student add(@RequestBody Student student){
        System.out.println("Có khách đang thêm sinh viên mới: " + student.getName());
        return studentService.add(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student){
        System.out.println("Khách muốn sửa sinh viên: " + id);
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        System.out.println("Khách muốn xóa sinh viên: " + id);
        studentService.detete(id);
        return "Đã xóa thành công sinh viên: " + id;
    }
}
