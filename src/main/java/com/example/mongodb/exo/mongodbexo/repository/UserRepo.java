package com.example.mongodb.exo.mongodbexo.repository;

import com.example.mongodb.exo.mongodbexo.dto.UserDto;
import com.example.mongodb.exo.mongodbexo.model.User;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserRepo extends ReactiveMongoRepository<User, String> {
    Flux<UserDto> findByAgeBetween(Range<Double> closed);
}
