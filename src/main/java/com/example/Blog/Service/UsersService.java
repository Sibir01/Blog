package com.example.Blog.Service;

import com.example.Blog.DTO.UsersDto;
import com.example.Blog.exeption.ValidationException;

import java.util.List;

public interface UsersService {

    UsersDto saveUser(UsersDto usersDto) throws  ValidationException;

    void deleteUser(Integer userId);

    UsersDto findByLogin(String login);

    List<UsersDto> findAll();
}
