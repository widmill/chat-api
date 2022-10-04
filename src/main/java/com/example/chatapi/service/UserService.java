package com.example.chatapi.service;

import com.example.chatapi.entity.User;
import com.example.chatapi.exception.EntityAlreadyExistException;
import com.example.chatapi.exception.NullFieldException;
import com.example.chatapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Long createUser(User user) {

        if (user.getUsername() == null || user.getUsername().isBlank()) {

            throw new NullFieldException("Username must be filled.");

        }

        if (userRepository.findByUsername(user.getUsername()) != null) {

            throw new EntityAlreadyExistException(
                    "User with name " + user.getUsername() + " already exists.");
        }

        userRepository.save(user);

        log.info("User successfully created: {}", user);

        return user.getId();
    }

}
