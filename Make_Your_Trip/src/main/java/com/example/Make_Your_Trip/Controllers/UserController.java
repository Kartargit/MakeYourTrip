package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDtos.AddUserDto;
import com.example.Make_Your_Trip.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;
    @PostMapping("/add")
    public String addUser(@RequestBody AddUserDto addUserDto){
        return userServices.addUser(addUserDto);
    }
}
