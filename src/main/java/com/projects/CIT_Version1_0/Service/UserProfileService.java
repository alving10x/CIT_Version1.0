package com.projects.CIT_Version1_0.Service;

import com.projects.CIT_Version1_0.dao.UserProfileDao;
import com.projects.CIT_Version1_0.model.LoginRequest;
import com.projects.CIT_Version1_0.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    UserProfileDao userProfileDao;
    public ResponseEntity<List<UserProfile>> getAllUsers() {
        try {
            return new ResponseEntity<>(userProfileDao.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
}

    public ResponseEntity<String> addUser(UserProfile userProfile) {

        try {
            userProfileDao.save(userProfile);
            return new ResponseEntity<>( HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>( HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> loginUser(LoginRequest loginRequest) {
        {

            List<UserProfile> userProfiles = userProfileDao.findAllWithSelectedColumns();
            for (UserProfile user : userProfiles) {
                if (user.getUsername().equals(loginRequest.getUsername())
                        && user.getPassword().equals(loginRequest.getPassword())) {
                    return new ResponseEntity<String>(HttpStatus.OK);
                }
            }
            return new ResponseEntity<String>( HttpStatus.UNAUTHORIZED);

        }
    }
}
