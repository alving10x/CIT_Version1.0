package com.projects.CIT_Version1_0.controller;

import com.projects.CIT_Version1_0.Service.UserProfileService;
import com.projects.CIT_Version1_0.dao.UserProfileDao;
import com.projects.CIT_Version1_0.model.LoginRequest;
import com.projects.CIT_Version1_0.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;
    @Autowired
    UserProfileDao userProfileDao;

    @GetMapping("/getUsers")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<UserProfile>> getUsers(){

        return userProfileService.getAllUsers();
    }

    @PostMapping("/addUser")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> addUser(@RequestBody UserProfile userProfile){

            return userProfileService.addUser(userProfile);
    }

    @PostMapping("/loginUser")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest){
        return userProfileService.loginUser(loginRequest);
    }


}