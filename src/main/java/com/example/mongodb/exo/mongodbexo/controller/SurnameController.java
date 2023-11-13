package com.example.mongodb.exo.mongodbexo.controller;

import com.example.mongodb.exo.mongodbexo.model.Surname;
import com.example.mongodb.exo.mongodbexo.service.SurnameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/surname")
public class SurnameController {

    SurnameService myService;

    public SurnameController(SurnameService myService) {
        this.myService = myService;
    }

    @GetMapping()
    public List<Surname> getAllSurname(){
        return myService.getAllSurname();
    }
}
