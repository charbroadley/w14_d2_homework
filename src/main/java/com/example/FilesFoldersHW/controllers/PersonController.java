package com.example.FilesFoldersHW.controllers;

import com.example.FilesFoldersHW.models.Person;
import com.example.FilesFoldersHW.repositories.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonRespository personRespository;

    @GetMapping(value = "/persons")
    public ResponseEntity<List<Person>> getAllPeople() {
        return new ResponseEntity<>(personRespository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/persons/{id}")
    public Optional<Person> getPerson(@PathVariable Long id) {
        return personRespository.findById(id);
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {
        personRespository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

}
