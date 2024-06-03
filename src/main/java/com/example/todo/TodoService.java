
package com.example.todo;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.todo.Todo;
import com.example.todo.TodoRepository;

import java.util.*;

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();

    int uniqueId = 6;

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    @Override
    public ArrayList<Todo> getAllTodos() {
        Collection<Todo> todosCollection = todoList.values();
        ArrayList<Todo> todos = new ArrayList<>(todosCollection);
        return todos;
    }

    @Override
    public Todo addTodo(Todo todo) {
        todo.setTodoId(uniqueId);
        todoList.put(uniqueId, todo);
        uniqueId += 1;
        
        return todo;
    }

    @Override
    public Todo getTodoById(int todoId) {
        Todo todo = todoList.get(todoId);
        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return todo;
    }

    @Override
    public Todo updateTodo(int todoId, Todo todo) {
        Todo ExisitingTodo = todoList.get(todoId);
        if (ExisitingTodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (todo.getTodo() != null) {
            ExisitingTodo.setTodo(todo.getTodo());
        }
        if (todo.getPriority() != null) {
            ExisitingTodo.setPriority(todo.getPriority());
        }
        if (todo.getStatus() != null) {
            ExisitingTodo.setStatus(todo.getStatus());
        }

        return ExisitingTodo;
    }

    @Override
    public void deleteTodo(int todoId) {
        Todo todo = todoList.get(todoId);
        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            todoList.remove(todoId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
