package com.example.todo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Đây là bảng
@Table(name = "todos")// Tên Bảng
public class Todo {
    @Id // khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID tự tăng(1,2,3,...)
    private Long id;
    @NotBlank(message = "Tiêu đề không được để trống")
    private String title;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
