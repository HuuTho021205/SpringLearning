package com.example.todo.servicetodo;

import com.example.todo.Todo;
import com.example.todo.repotodo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repoTodo;

    public List<Todo> getAll(){
        return repoTodo.findAll();
    }

    public Todo add(Todo todo){
        todo.setCompleted(false);
        return repoTodo.save(todo);
    }

    public Todo updateTitle (Long id, Todo newInfo){
        return repoTodo.findAll().stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .map(todo -> {
                    todo.setTitle(newInfo.getTitle());
                    return todo;
                })
                .orElse(null);
    }

    public Todo updateStatus (Long id ){
        return repoTodo.findAll().stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .map(todo -> {
                    todo.setCompleted(!todo.isCompleted());
                    return todo;
                })
                .orElse(null);
    }

    public void delete(Long id){
        repoTodo.findAll().removeIf(todo -> todo.getId().equals(id));

    }
}
