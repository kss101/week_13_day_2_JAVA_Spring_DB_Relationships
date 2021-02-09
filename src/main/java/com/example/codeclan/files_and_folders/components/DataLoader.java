package com.example.codeclan.files_and_folders.components;

import com.example.codeclan.files_and_folders.models.File;
import com.example.codeclan.files_and_folders.models.Folder;
import com.example.codeclan.files_and_folders.models.User;
import com.example.codeclan.files_and_folders.repositories.FileRepository;
import com.example.codeclan.files_and_folders.repositories.FolderRepository;
import com.example.codeclan.files_and_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        User kurt = new User("Kurt");
        userRepository.save(kurt);

        Folder myDocs = new Folder("My Documents", kurt);
        folderRepository.save(myDocs);

        Folder myProjs = new Folder("My Projects", kurt);
        folderRepository.save(myProjs);

        File file1 = new File("Files and Folders", ".jav", 7000, myDocs);
        fileRepository.save(file1);

        File file2 = new File("Folders and Files", ".doc", 17000, myDocs);
        fileRepository.save(file2);

        File file3 = new File("Another File", ".doc", 17000, myProjs);
        fileRepository.save(file3);
    }

}
