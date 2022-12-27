package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.mapper.UserMapper;
import com.example.userservice.model.User;
import com.example.userservice.service.impl.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Mono<User>> create(@RequestBody UserDto userDto) {

        UserMapper mapper = Mappers.getMapper(UserMapper.class);
        User user = mapper.toEntity(userDto);
        if (user != null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Flux<User>> listAll() {
        return ResponseEntity.ok().body(this.userService.findAll());
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody UserDto userDto) {
        UserMapper mapper = Mappers.getMapper(UserMapper.class);
        User user = mapper.toEntity(userDto);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<User>> get(@PathVariable UUID id) {
       Mono<User> user = this.userService.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
