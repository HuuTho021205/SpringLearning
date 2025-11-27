package com.example.todo.controllertodo;

import com.example.todo.Todo;
import com.example.todo.servicetodo.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    public final TodoService serviceTodo;

    @GetMapping
    public ResponseEntity<List<Todo>> getList() {
        System.out.println("Khách hàng đang xem danh sách việc");
        return ResponseEntity.ok(serviceTodo.getAll());
    }

    @PostMapping

    public ResponseEntity<Todo> add(@Valid @RequestBody Todo todo) {
        System.out.println("Khách đang thêm việc mới");
        return ResponseEntity.ok(serviceTodo.add(todo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTitle(@PathVariable Long id, @RequestBody Todo todo) {
        System.out.println("Khách đang sửa title");
        return ResponseEntity.ok(serviceTodo.updateTitle(id,todo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> updateStatus(@PathVariable Long id, @RequestBody Todo todo) {
        System.out.println("Khách đang sửa status");
        return ResponseEntity.ok(serviceTodo.updateStatus(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        System.out.println("Khách đang xóa việc");
        boolean isDeleted = serviceTodo.delete(id);
        if (isDeleted) {
            serviceTodo.delete(id);
            return ResponseEntity.ok("Đã xóa thành công công việc có mã" + id);
        }
        return ResponseEntity.notFound().build();
    }
}

