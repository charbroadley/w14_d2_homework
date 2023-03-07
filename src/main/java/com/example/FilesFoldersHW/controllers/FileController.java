package com.example.FilesFoldersHW.controllers;

import com.example.FilesFoldersHW.models.File;
import com.example.FilesFoldersHW.models.Folder;
import com.example.FilesFoldersHW.models.Person;
import com.example.FilesFoldersHW.repositories.FileRepository;
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

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles() {
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public Optional<File> getFile(@PathVariable Long id) {
        return fileRepository.findById(id);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> postPerson(@RequestBody File file) {
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}



