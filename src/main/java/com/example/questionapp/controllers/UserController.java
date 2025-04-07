package com.example.questionapp.controllers;

import com.example.questionapp.entities.User;
import com.example.questionapp.exceptions.UserNotFoundException;
import com.example.questionapp.responses.UserResponse;
import com.example.questionapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return new UserResponse(user);
    }

    @PutMapping("/{userId}")
    public User updateUserById(@PathVariable Long userId, @RequestBody User newUser) {
        return userService.updateUserById(userId, newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }

    @GetMapping("/activity/{userId}")
    public List<Object> getUserActivityById(@PathVariable Long userId) {
        return userService.getUserActivityById(userId);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleUserNotFoundException() {
    }
}
