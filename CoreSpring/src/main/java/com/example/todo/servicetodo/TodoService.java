package com.example.todo.servicetodo;

import com.example.todo.entity.Category;
import com.example.todo.entity.Todo;
import com.example.todo.dto.TodoDTO;
import com.example.todo.entity.User;
import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.repotodo.CategoryRepository;
import com.example.todo.repotodo.TodoRepository;
import com.example.todo.repotodo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repoTodo;
    private final CategoryRepository repoCategory;
    private final UserRepository userRepository;
    //1.Lấy danh sách
    public List<TodoDTO> getAll(){
        // Jpa tự động tạo câu lệnh sql select * from todos
        return repoTodo.findAll().stream()
                .map(todo -> toDTO(todo))
                .toList();
    }
//    2. Thêm mới
    public TodoDTO add(TodoDTO dto){
//        Lấy username của người đang đăng nhập từ "Thẻ bài" (SecurityContext)
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
//        Tìm User đó trong Database
        User currentUser = userRepository.findByUsername(currentUsername)
                .orElseThrow(()-> new RuntimeException("Không tìm thấy người dùng"));
        Todo todo = toEntity(dto);
        todo.setUser(currentUser);
        // Không cần tự tính id vì set identity ở class todo
        // sql server tự tạo câu lệnh insert into
        Todo savedTodo = repoTodo.save(todo);
        return toDTO(savedTodo);
    }
//  3. sửa tiêu đề không tìm thấy id là ném lỗi luôn
    public TodoDTO updateTitle (Long id, TodoDTO newInfoDTO) {
        // dùng hàm findbyid để database tìm hộ
        Todo todo = repoTodo.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id)); //ném lôĩ
        todo.setTitle((newInfoDTO.getTitle()));

        Todo savedTodo = repoTodo.save(todo);
        // jpa tự tạo câu lệnh sql update todos set ... where id
        return toDTO(savedTodo);
    }
    //4. sửa status
    public TodoDTO updateStatus (Long id ){
        Todo todo = repoTodo.findById(id).orElseThrow(()-> new TodoNotFoundException(id));

            todo.setCompleted(!todo.isCompleted());
            Todo savedTodo = repoTodo.save(todo);
            return toDTO(savedTodo);
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
    // chuyển dto sang entity
    public Todo toEntity(TodoDTO dto){
        Todo todoEntity = new Todo();
        todoEntity.setTitle(dto.getTitle());
        todoEntity.setCompleted(false);

        if (dto.getCategoryId() != null){
            Category category = repoCategory.findById(dto.getCategoryId())
                    .orElse(null);
            todoEntity.setCategory(category);
        }

        return todoEntity;
    }

//    chuyển entity sang dto

    public TodoDTO toDTO(Todo todo){
        TodoDTO dto = new TodoDTO();

        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setCompleted(false);

        if (todo.getCategory() != null){
            dto.setCategoryId(todo.getCategory().getCategoryID());
            dto.setCategoryName(todo.getCategory().getCategoryName());
        }

        return dto;
    }
}
