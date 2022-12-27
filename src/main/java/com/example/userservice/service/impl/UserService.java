package com.example.userservice.service.impl;

import com.example.userservice.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserService{
    Mono<User> addUser(User user);

    Mono<Void> deleteById(UUID id);
    Flux<User> findAll();

    Mono<User> findById(UUID id);
    Mono<User> update(User user);

}
