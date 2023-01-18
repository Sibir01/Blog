package com.example.Blog.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsersDto {

    private Integer id;
    private String name;
    private String login;
    private String email;

}

//DTO is a simple java class that is used to transfer data between layers.
//Also, this class will serve as a transfer between the client, the controller and the service.