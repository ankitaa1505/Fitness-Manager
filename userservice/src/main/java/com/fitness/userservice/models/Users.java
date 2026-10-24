package com.fitness.userservice.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table( name = "users")
@Data

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;
    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password ;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER ;
   @CreationTimestamp
    private LocalDateTime createdAt;
   @UpdateTimestamp
    private LocalDateTime updatedAt;

}
