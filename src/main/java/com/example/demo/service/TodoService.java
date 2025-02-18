package com.example.demo.service;

import com.example.demo.dto.TodoRequestDto;
import com.example.demo.dto.TodoResponseDto;
import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;

@Service
public class TodoService {

    private static final Logger logger = LoggerFactory.getLogger(TodoService.class);

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
         this.todoRepository = todoRepository;
    }

    //모든 TodList 조회
    public List<TodoResponseDto> getAllTodoList() {
        return todoRepository.findAll().stream().map(todo -> new TodoResponseDto(todo.getId(),todo.getTitle(),todo.isCompleted()))
                .collect(Collectors.toList());
   }

      //TodoLISt 생성
     public TodoResponseDto createTodo(TodoRequestDto dto){

        Todo todo = new Todo();
        todo.setTitle(dto.getTitle());
        todo.setCompleted(dto.isCompleted());

        logger.debug("todolist정보: {}",dto);
        Todo savedTodo =  todoRepository.save(todo);

        return new TodoResponseDto(savedTodo.getId(),savedTodo.getTitle(),savedTodo.isCompleted());
     }

    //TodoList 업데이트
    public TodoResponseDto updateDto(Long id, TodoRequestDto dto){
        return todoRepository.findById(id).map(todo ->{
            todo.setTitle(dto.getTitle());
            todo.setCompleted(dto.isCompleted());

            Todo update = todoRepository.save(todo);
            return new TodoResponseDto(update.getId(), update.getTitle(),update.isCompleted());
        }).orElseThrow(() -> new RuntimeException("todo 없다"));
    }

    //TodoList 삭제
    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

}
