package com.TodoApplication.App.Repository;

import com.TodoApplication.App.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {

    Optional<Object> findByUserName(String name);
}
