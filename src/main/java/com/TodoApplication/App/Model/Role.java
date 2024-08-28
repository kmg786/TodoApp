package com.TodoApplication.App.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @NotBlank
    @Column(name = "role_name",length = 20)
    @Size(min = 4,max = 5,message = "Role must be contain at least 4 characters")
    private String role;

}