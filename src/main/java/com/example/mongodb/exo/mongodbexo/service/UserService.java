package com.example.mongodb.exo.mongodbexo.service;

import com.example.mongodb.exo.mongodbexo.dto.UserDto;
import com.example.mongodb.exo.mongodbexo.repository.UserRepo;
import com.example.mongodb.exo.mongodbexo.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Mono<UserDto> getUserFromDbById(String id) {
        return userRepo.findById(id).map(AppUtils::userToUserDto);
    }

    public Flux<UserDto> getUserByRangeAge(double min, double max) {
        return userRepo.findByAgeBetween(Range.closed(min, max));
    }

    public Flux<UserDto> getAllUsers() {
        return userRepo.findAll().map(AppUtils::userToUserDto);
    }

    public Mono<UserDto> updateUser(String id, Mono<UserDto> userDto) {
        return userRepo.findById(id)
                .flatMap(p -> userDto
                        .map(AppUtils::userDtoToUser)
                        .doOnNext(s -> s.setId(id)))
                .flatMap(userRepo::save)
                .map(AppUtils::userToUserDto);

    }

    public Mono<UserDto> createUser(Mono<UserDto> userDto) {
        return userDto
                .map(AppUtils::userDtoToUser)
                .flatMap(userRepo::insert)
                .map(AppUtils::userToUserDto);
    }

    public Mono<Void> deleteUser(String id) {
        return userRepo.deleteById(id);
    }
}
