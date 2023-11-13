package com.example.mongodb.exo.mongodbexo.controller;

import com.example.mongodb.exo.mongodbexo.dto.UserDto;
import com.example.mongodb.exo.mongodbexo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService myService;


    @GetMapping("/{id}")
    public Mono<UserDto> getUserById(@PathVariable String id) {
        return myService.getUserFromDbById(id);
    }

    @GetMapping()
    public Flux<UserDto> getAllUsers() {
        return myService.getAllUsers();
    }

    @GetMapping("/age-range")
    public Flux<UserDto> getUserRangeAge(@RequestParam Double min, @RequestParam Double max) {
        return myService.getUserByRangeAge(min, max);
    }

    @PostMapping()
    public Mono<UserDto> createUser(@RequestBody Mono<UserDto> userDto) {
        return myService.createUser(userDto);
    }

    @PutMapping("/{id}")
    public Mono<UserDto> updateUser(@PathVariable String id, @RequestBody Mono<UserDto> userDto) {
        return myService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable String id) {
        return myService.deleteUser(id);
    }

}
