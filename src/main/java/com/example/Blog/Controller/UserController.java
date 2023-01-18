package com.example.Blog.Controller;


import com.example.Blog.DTO.UsersDto;
import com.example.Blog.Service.DefaultUsersService;
import com.example.Blog.Service.UsersService;
import com.example.Blog.exeption.ValidationException;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This class will be responsible for processing requests for working with the User entity
@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
public class UserController {
    private final UsersService usersService;

    @PostMapping("/save")
    public UsersDto saveUsers(@RequestBody UsersDto usersDto) throws  ValidationException {
        log.info("Handling save users: " + usersDto);
        return usersService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UsersDto> findAllUsers() {
        log.info("Handling find all users request");
        return usersService.findAll();
    }

    @GetMapping("/findByLogin")
    public UsersDto findByLogin(@RequestParam String login) {
        log.info("Handling find by login request: " + login);
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}

