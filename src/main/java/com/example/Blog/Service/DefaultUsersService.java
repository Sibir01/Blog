package com.example.Blog.Service;

import com.example.Blog.DTO.UsersDto;
import com.example.Blog.Repository.UserRepository;
import com.example.Blog.entity.Users;
import com.example.Blog.exeption.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUsersService implements UsersService {

    private final UserRepository usersRepository;
    private final UsersConverter usersConverter;


    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
        //convert saved user back to dto and return
    }

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
        //In the deleteUser method, I simply delete the user by id
    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = usersRepository.findByLogin(login);
        if (users != null) {
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
        //if the user is found in the database, we will convert it to dto. If not found, return null
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
        //We blame all users from the database and then we convert them into a list of DTO
    }

}

