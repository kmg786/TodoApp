package com.TodoApplication.App.Controller;

import com.TodoApplication.App.Model.Task;
import com.TodoApplication.App.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add/task")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/task/taskid/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        return new ResponseEntity<>(taskService.getTaskById(id),HttpStatus.OK);
    }

    @GetMapping("/task/taskname/{name}")
    public ResponseEntity<Task> getTaskById(@PathVariable String name){
        return new ResponseEntity<>(taskService.getTaskByNameLike(name),HttpStatus.OK);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task,@PathVariable Long id){
        return new ResponseEntity<>(taskService.updateTask(task,id),HttpStatus.OK);
    }

    @DeleteMapping("/task/delete/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
        return new ResponseEntity<>(taskService.deleteTask(id),HttpStatus.OK);
    }
}
