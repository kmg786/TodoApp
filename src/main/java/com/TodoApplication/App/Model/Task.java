package com.TodoApplication.App.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @NotBlank
    @Size(min = 3,message = "Task Name should be at least 3 characters long..")
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(min = 3,max = 150,message = "Description should be at least 3 characters long..")
    @Column(name = "description")
    private String description;

    private Boolean status;

    @Column(name = "modify_user")
    private String modifyUser;
    @Column(name = "modify_ts")
    private LocalDateTime modifyTs;
    @Column(name = "create_user")
    private String createUser;
    @Column(name = "create_ts")
    private LocalDateTime createTs;

    public Task(String name, String description, Boolean status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }
}
