package com.example.Make_Your_Trip.Services;

import com.example.Make_Your_Trip.Models.Users;
import com.example.Make_Your_Trip.Repositories.UserRepository;
import com.example.Make_Your_Trip.RequestDtos.AddUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender mailSender;
    public String addUser(AddUserDto addUserDto){
        Users user = Users.builder().name(addUserDto.getName())
                .age(addUserDto.getAge()).emailId(addUserDto.getEmailId()).build();
        userRepository.save(user);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String body = " Hi! "+user.getName()+"\n"+""+"Welcome to MakeYourTrip website. Book your flights, Train and Buses conveniently hear";
        mailMessage.setSubject("Welcome to Make Your Trip");
        mailMessage.setFrom("skartar61962@gmail.com");
        mailMessage.setTo(user.getEmailId());
        mailMessage.setText(body);
        mailSender.send(mailMessage);

        return "User has been added to database Successfully";
    }
}
