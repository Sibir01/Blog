package com.example.Blog.Service;


import com.example.Blog.DTO.UsersDto;
import com.example.Blog.Repository.UserRepository;
import com.example.Blog.entity.Users;
import jakarta.xml.bind.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.Blog.Prototype.UsersPrototype.aUser;
import static com.example.Blog.Prototype.UsersPrototype.aUserDTO;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultUsersServiceTest {

    private UserRepository userRepository;
    private UsersConverter usersConverter;
    private UsersService usersService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        usersConverter = new UsersConverter();
        usersService = new DefaultUsersService(userRepository, usersConverter);
    }

    @Test
    void saveUser() throws ValidationException, com.example.Blog.exeption.ValidationException {
        when(userRepository.save(any())).thenReturn(aUser());
        UsersDto createdUser = usersService.saveUser(aUserDTO());
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getName()).isEqualTo(aUserDTO().getName());
    }




    @Test
    void deleteUser() {
    }

    @Test
    void findByLogin() {
        when(userRepository.findByLogin(eq("test_login"))).thenReturn(aUser());
        UsersDto foundUser = usersService.findByLogin("test_login");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getLogin()).isEqualTo("test_login");
    }

    @Test
    void findAll() {
    }
}
