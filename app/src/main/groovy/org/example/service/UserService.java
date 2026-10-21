package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.bean.UserConfig;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class UserService {

    UserConfig userConfig;


    public UserService(UserConfig userConfig){
        this.userConfig = userConfig;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    public  class User {
        private String name;
        private String age;
        private String address;
    }

    private User user;
    public UserService(){
        this.user = new User("aman","33", "Banglore");

    }
    public  void logIn(){
        System.out.println("logging user ");
    }

}


