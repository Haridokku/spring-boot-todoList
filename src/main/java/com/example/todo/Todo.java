package com.example.todo;

public class Todo {
    private int todoId;
    private String todo;
    private String priority;
    private String status;

    public Todo(int todoId, String todo, String priority, String status) {
        this.todoId = todoId;
        this.todo = todo;
        this.priority = priority;
        this.status = status;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}