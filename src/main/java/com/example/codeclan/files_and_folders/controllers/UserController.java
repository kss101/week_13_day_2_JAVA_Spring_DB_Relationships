package com.example.codeclan.files_and_folders.controllers;

import com.example.codeclan.files_and_folders.models.Folder;
import com.example.codeclan.files_and_folders.models.User;
import com.example.codeclan.files_and_folders.repositories.FolderRepository;
import com.example.codeclan.files_and_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
