package com.example.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TodoDTO {
    private Long id;

    @NotBlank(message = "Title không được để trống")
    private String title;
    private boolean completed;

    private Long categoryId;
    private String categoryName;
}
