package com.example.mongodb.exo.mongodbexo.service;

import com.example.mongodb.exo.mongodbexo.dao.PersonRepository;
import java.util.List;

import com.example.mongodb.exo.mongodbexo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonRepository myRepoPerson;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.myRepoPerson = personRepository;
    }

    public List<Person> getAllPerson(){
        return myRepoPerson.findAll();
    }
}
