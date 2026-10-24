package com.fitness.userservice.service;

import com.fitness.userservice.UserRepository;
import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.models.Users;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository ;

    public UserResponse register (RegisterRequest request){
    if(repository.existsByEmail(request.getEmail())){
        throw new RuntimeException("Email Already Exists");

    }

        Users users = new Users();
        users.setEmail(request.getEmail());
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        users.setPassword(request.getPassword());

        Users savedUsers = repository.save(users);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUsers.getId());
        userResponse.setPassword(savedUsers.getPassword());
        userResponse.setEmail(savedUsers.getEmail());
        userResponse.setFirstName(savedUsers.getFirstName());
        userResponse.setLastName(savedUsers.getLastName());
        userResponse.setCreatedAt(savedUsers.getCreatedAt());
        userResponse.setUpdatedAt(savedUsers.getUpdatedAt());
        return userResponse ;



    }
}
