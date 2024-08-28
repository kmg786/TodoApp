package com.TodoApplication.App.Service;

import com.TodoApplication.App.Model.Task;

import java.util.List;


public interface TaskService {
    Task createTask(Task task);

    Task getTaskById(Long id);

    Task getTaskByNameLike(String name);

    Task updateTask(Task task,Long id);

    Task deleteTask(Long id);
}
