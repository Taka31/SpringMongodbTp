package com.example.mongodb.exo.mongodbexo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "UserCollection")
public class User {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String address;


}