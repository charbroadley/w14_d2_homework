package com.example.FilesFoldersHW.controllers;

import com.example.FilesFoldersHW.models.Folder;
import com.example.FilesFoldersHW.models.Person;
import com.example.FilesFoldersHW.repositories.FolderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    FolderRespository folderRespository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders() {
        return new ResponseEntity<>(folderRespository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public Optional<Folder> getPerson(@PathVariable Long id) {
        return folderRespository.findById(id);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> postPerson(@RequestBody Folder folder) {
        folderRespository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }
}
