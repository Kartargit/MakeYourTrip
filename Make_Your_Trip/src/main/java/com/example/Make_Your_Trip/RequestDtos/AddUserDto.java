package com.example.Make_Your_Trip.RequestDtos;

import lombok.Data;

@Data
public class AddUserDto {
    private String name;
    private String emailId;
    private Integer age;
}
