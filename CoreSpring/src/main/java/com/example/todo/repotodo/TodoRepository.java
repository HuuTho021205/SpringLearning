package com.example.todo.repotodo;

import com.example.todo.Todo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository {
    private List<Todo> todoList = new ArrayList<>();
    private long autoid = 1;

    @PostConstruct
    public void inittodo(){
        todoList.add(new Todo(autoid++,"Học bài", false));
        todoList.add(new Todo(autoid++, "Chạy bộ", false));
        System.out.println("Đã tạo 2 công việc");
    }

    public List<Todo> findAll(){
        return todoList;
    }

    public Todo save(Todo todo){
        todo.setId(autoid++);
        todoList.add(todo);
        return todo;
    }
}
