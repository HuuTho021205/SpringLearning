package com.example.mvc.controller;

import com.example.mvc.model.Student;
import com.example.mvc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getList(){
        System.out.println("Có khách đang xem danh sách sinh viên");
        return ResponseEntity.ok(studentService.getAll());
    }

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student){
        System.out.println("Có khách đang thêm sinh viên mới: " + student.getName());
        return ResponseEntity.ok(studentService.add(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){
        System.out.println("Khách muốn sửa sinh viên: " + id);
        Student result = studentService.update(id, student);
        if (result == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        System.out.println("Khách muốn xóa sinh viên: " + id);
        studentService.detete(id);
        return ResponseEntity.ok("Đã xóa thành công sinh viên: " + id);
    }
}
