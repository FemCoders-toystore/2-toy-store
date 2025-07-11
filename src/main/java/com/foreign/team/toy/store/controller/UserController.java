package com.foreign.team.toy.store.controller;

import com.foreign.team.toy.store.model.User;
import com.foreign.team.toy.store.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping("/api/users")
    public class UserController {
        private final UserService userService;
        public UserController(UserService userService) {
            this.userService = userService;
        }
        @GetMapping
        public List<User> getAllUsers() {
            return userService.getAllUsers();
        }
        @GetMapping("/{id}")
        public User getUserById(@PathVariable Long id){
            return userService.getUserById(id);
        }
        @PostMapping
        public User createUser(@RequestBody @Valid User user) {
            return userService.createUser(user);
        }

        @PutMapping("/{id}")
        public User updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
            return userService.updateUser(id, user);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id){
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
    }

