package com.example.mongodb.exo.mongodbexo.controller;

import com.example.mongodb.exo.mongodbexo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    PersonService myService;

    @Autowired
    public PersonController(PersonService myService) {
        this.myService = myService;
    }

    @GetMapping()
    public List getAllNames(){
        return myService.getAllPerson();
    }
}
