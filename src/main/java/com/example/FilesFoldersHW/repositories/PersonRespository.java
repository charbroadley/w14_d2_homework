package com.example.FilesFoldersHW.repositories;

import com.example.FilesFoldersHW.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRespository extends JpaRepository<Person, Long> {
}
