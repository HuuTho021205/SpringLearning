package com.example.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // đánh dấu đây là nơi bắt lỗi do hệ thống ném ra
// sau đó trả về thông tin cần thiết thay vì 1 đống shit

public class GlobalExceptionHandler {

//    chuyên bắt lỗi 400 do valid ném ra(Lỗi validate)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        System.out.println("🔥 DEBUG: Đã bắt được lỗi Validation!");
//        lọc ra chỉ lấy tên trường bị lỗi và thôn báo lỗi
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

//        trả về json gọn gàng {"title" : "Tiêu đề khng được để trống"
        return ResponseEntity.badRequest().body(errors);
    }

    // Bắt lỗi: Gửi JSON sai định dạng (thiếu ngoặc, sai kiểu dữ liệu...)
    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleJsonErrors(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Dữ liệu gửi lên không đúng định dạng JSON hoặc sai kiểu dữ liệu!");
        return ResponseEntity.badRequest().body(error);
    }
    // Bắt lỗi TodoNotFoundException
    @ExceptionHandler(TodoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // Trả về 404
    public ResponseEntity<Map<String, String>> handleNotFound(TodoNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage()); // Lấy câu thông báo "Không tìm thấy..."
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
