package com.example.todo.exception;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(Long id){
        super("Không tìm thấy công việc có ID: " + id);
    }
}
