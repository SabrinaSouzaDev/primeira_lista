package com.primeira_lista.primeiro.service;

import java.util.List;

import com.primeira_lista.primeiro.model.Task;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task createTask(Task task);
    Task updateTask(Long id, Task taskDetails);
    void deleteTask(Long id);
}