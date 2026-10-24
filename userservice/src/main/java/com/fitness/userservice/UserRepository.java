package com.fitness.userservice;

import com.fitness.userservice.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
    Boolean existsByEmail(String email);
}
