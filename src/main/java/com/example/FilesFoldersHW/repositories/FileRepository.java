package com.example.FilesFoldersHW.repositories;

import com.example.FilesFoldersHW.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
