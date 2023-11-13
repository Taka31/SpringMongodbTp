package com.example.mongodb.exo.mongodbexo.service;

import com.example.mongodb.exo.mongodbexo.dao.SurnameRepository;
import com.example.mongodb.exo.mongodbexo.model.Surname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurnameService {

    SurnameRepository myRepo;

    @Autowired
    public SurnameService(SurnameRepository myRepo) {
        this.myRepo = myRepo;
    }

    public List<Surname> getAllSurname(){
        return myRepo.findAll();
    }
}
