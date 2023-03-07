package com.example.FilesFoldersHW.components;

import com.example.FilesFoldersHW.models.File;
import com.example.FilesFoldersHW.models.Folder;
import com.example.FilesFoldersHW.models.Person;
import com.example.FilesFoldersHW.repositories.FileRepository;
import com.example.FilesFoldersHW.repositories.FolderRespository;
import com.example.FilesFoldersHW.repositories.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
// @Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PersonRespository personRespository;

    @Autowired
    FolderRespository folderRespository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){};

    public void run(ApplicationArguments args) {
        Person catherine = new Person("Catherine");
        personRespository.save(catherine);

        Folder recipes = new Folder("Recipes", catherine);
        folderRespository.save(recipes);

        Folder bankDocs = new Folder("Bank Docs", catherine);
        folderRespository.save(bankDocs);

        File risotto = new File("Fancy Vegetable Risotto", ".doc", 1, recipes);
        fileRepository.save(risotto);

        File bibimbap = new File("Bibimbap", ".pdf", 2, recipes);
        fileRepository.save(bibimbap);

        File bankStuff = new File("An Important Bank Thing", ".pdf", 2, bankDocs);
        fileRepository.save(bankStuff);
    }
}
