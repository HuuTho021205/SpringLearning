package com.example.todo.servicetodo;

import com.example.todo.Todo;
import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.repotodo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repoTodo;
    //1.Lấy danh sách
    public List<Todo> getAll(){
        // Jpa tự động tạo câu lệnh sql select * from todos
        return repoTodo.findAll();
    }
//    2. Thêm mới
    public Todo add(Todo todo){
        // Không cần tự tính id vì set identity ở class todo
        todo.setCompleted(false);
        // sql server tự tạo câu lệnh insert into
        return repoTodo.save(todo);
    }
//  3. sửa tiêu đề không tìm thấy id là ném lỗi luôn
    public Todo updateTitle (Long id, Todo newInfo) {
        // dùng hàm findbyid để database tìm hộ
        Todo todo = repoTodo.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id)); //ném lôĩ
        todo.setTitle((newInfo.getTitle()));

        // jpa tự tạo câu lệnh sql update todos set ... where id
        return repoTodo.save(todo);
    }
    //4. sửa status
    public Todo updateStatus (Long id ){
        Todo todo = repoTodo.findById(id).orElseThrow(()-> new TodoNotFoundException(id));

            todo.setCompleted(!todo.isCompleted());

            return repoTodo.save(todo);
    }
//    5.Xóa
    public boolean delete(Long id){
        if (repoTodo.existsById(id)){
            //jpa tự tạo câu lệnh sql delete from todos where id =
            repoTodo.deleteById(id);
            return true;
        }
        return false;

    }
}
