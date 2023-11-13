package com.example.mongodb.exo.mongodbexo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String id;
    private String address;
    private Integer age;
    private String name;
}
