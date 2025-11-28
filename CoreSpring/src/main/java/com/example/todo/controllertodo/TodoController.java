package com.example.todo.controllertodo;

import com.example.todo.dto.TodoDTO;
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
    public ResponseEntity<List<TodoDTO>> getList() {
        System.out.println("Khách hàng đang xem danh sách việc");
        return ResponseEntity.ok(serviceTodo.getAll());
    }

    @PostMapping

    public ResponseEntity<TodoDTO> add(@Valid @RequestBody TodoDTO todoDTO) {
        System.out.println("Khách đang thêm việc mới");
        return ResponseEntity.ok(serviceTodo.add(todoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTitle(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {
        System.out.println("Khách đang sửa title");
        return ResponseEntity.ok(serviceTodo.updateTitle(id,todoDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoDTO> updateStatus(@PathVariable Long id) {
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

