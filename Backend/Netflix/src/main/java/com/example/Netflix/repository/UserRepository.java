package com.example.Netflix.repository;

import org.springframework.stereotype.Repository;
import com.example.Netflix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom queries if needed
    Optional<User> findByEmail(String email);
}
