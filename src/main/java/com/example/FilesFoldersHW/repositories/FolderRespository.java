package com.example.FilesFoldersHW.repositories;

import com.example.FilesFoldersHW.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRespository extends JpaRepository<Folder, Long> {
}
