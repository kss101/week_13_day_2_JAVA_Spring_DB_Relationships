package com.example.codeclan.files_and_folders.controllers;

import com.example.codeclan.files_and_folders.models.Folder;
import com.example.codeclan.files_and_folders.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping("/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        List<Folder> allFolders = folderRepository.findAll();
        return new ResponseEntity<>(allFolders, HttpStatus.OK);
    }

    @GetMapping("/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolder(@PathVariable Long id){
        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/folders")
    public ResponseEntity<Folder> createNewFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }
}
