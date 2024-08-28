package com.TodoApplication.App.Service;

import com.TodoApplication.App.Model.Task;
import com.TodoApplication.App.Repository.TaskRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
//        taskRepository.save(task);
        Task newTask = new Task();
        newTask.setName(task.getName());
        newTask.setDescription(task.getDescription());
        newTask.setStatus(task.getStatus());
        newTask.setCreateTs(LocalDateTime.now());

//        GET LOGGED IN USER DETAILS AND ADD HERE
        newTask.setCreateUser("ADMIN");
        newTask.setModifyTs(LocalDateTime.now());
        newTask.setModifyUser("ADMIN");
        taskRepository.save(newTask);
        return newTask ;
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public Task getTaskByNameLike(String name) {
        return taskRepository.findByNameLike(name);
//        return null;
    }

    @Override
    public Task updateTask(Task task,Long id) {
        Task existingTask = taskRepository.findById(id).orElseThrow();
        existingTask.setName(task.getName());
        existingTask.setStatus(task.getStatus());
        existingTask.setDescription(task.getDescription());
        existingTask.setModifyTs(LocalDateTime.now());
        existingTask.setModifyUser("NEW_ADMIN");
        taskRepository.save(existingTask);
        return existingTask;
    }

    @Override
    public Task deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        taskRepository.deleteById(id);
        return task;
    }
}
