package org.example.controller;

import org.example.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticController {


    @Autowired
    private UserRoleRepository userRoleRepository;


    @GetMapping("roles")
    public ResponseEntity AuthenticateAndGetRoles() {
            return new ResponseEntity<>(userRoleRepository.findAll(), HttpStatus.OK);
    }


}
