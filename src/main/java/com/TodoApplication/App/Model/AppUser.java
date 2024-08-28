package com.TodoApplication.App.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Size(min = 3,max = 20,message = "Name should be at least 3 characters long..")
    @Column(name = "name")
    private String userName;

    @Email
    @NotBlank
    @Size(min = 3,max = 150,message = "Email should be at least 3 characters long..")
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(min = 3,max = 150,message = "Password should be at least 3 characters long..")
    @Column(name = "password")
    private String password;

    @Column(name = "modify_user")
    private String modifyUser;
    @Column(name = "modify_ts")
    private LocalDateTime modifyTs;
    @Column(name = "create_user")
    private String createUser;
    @Column(name = "create_ts")
    private LocalDateTime createTs;

    @Getter
    @Setter
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
}


