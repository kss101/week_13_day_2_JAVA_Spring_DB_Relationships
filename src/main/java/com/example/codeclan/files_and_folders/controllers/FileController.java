package com.example.codeclan.files_and_folders.controllers;

import com.example.codeclan.files_and_folders.models.File;
import com.example.codeclan.files_and_folders.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping("/files")
    public ResponseEntity<List<File>> getAllFiles(){
        List<File> allFiles = fileRepository.findAll();
        return new ResponseEntity<>(allFiles, HttpStatus.OK);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<Optional<File>> getFile(@PathVariable Long id){
        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/files")
    public ResponseEntity<File> createNewFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

}
