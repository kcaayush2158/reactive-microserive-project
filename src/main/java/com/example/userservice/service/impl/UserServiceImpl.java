package com.example.userservice.service.impl;


import com.example.userservice.dao.UserRepository;
import com.example.userservice.model.User;
import com.example.userservice.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Mono<User> addUser(User user) {
        log.info("User : {}" , user);
        return this.userRepository.save(user);
    }

    @Override
    public Mono<Void> deleteById(UUID id) {
       return this.userRepository.deleteById(id);
    }

    @Override
    public Flux<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Mono<User> findById(UUID id) {
        return this.userRepository.findById(id).switchIfEmpty(Mono.error(new UsernameNotFoundException("User not found")));
    }

    @Override
    public Mono<User> update(User user) {
        log.info("User : {}" , user);
        return this.userRepository.findById(user.getId())
                .flatMap(existingUser -> {
                    existingUser.setCoin(user.getCoin());
                    existingUser.setActive(user.isActive());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setUsername(user.getUsername());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setPhoneNumber(user.getPhoneNumber());
                    existingUser.setProfilePhoto(user.getProfilePhoto());
                    existingUser.setExpirationDate(user.getExpirationDate());
                    existingUser.setPhoneNumberVerified(user.isPhoneNumberVerified());
                    existingUser.setLastConnection(user.getLastConnection());
                    existingUser.setMaxAttempt(user.getMaxAttempt());
                    existingUser.setEmailVerified(user.isEmailVerified());
                    return  this.userRepository.save(existingUser);
                });
    }
}
