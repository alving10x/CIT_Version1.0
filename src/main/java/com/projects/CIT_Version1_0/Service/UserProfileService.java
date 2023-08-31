package com.projects.CIT_Version1_0.Service;

import com.projects.CIT_Version1_0.dao.UserProfileDao;
import com.projects.CIT_Version1_0.model.Incident;
import com.projects.CIT_Version1_0.model.LoginRequest;
import com.projects.CIT_Version1_0.model.UserProfile;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    UserProfileDao userProfileDao;
    public ResponseEntity<List<com.projects.CIT_Version1_0.view.UserProfile>> getAllUsers() {
    	try {
        	SimpleDateFormat dateTime = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz");
        	List<UserProfile> profiles = userProfileDao.findAll();
        	List<com.projects.CIT_Version1_0.view.UserProfile> profileResults = new ArrayList<com.projects.CIT_Version1_0.view.UserProfile>();
        	for(UserProfile profile : profiles) {
        		com.projects.CIT_Version1_0.view.UserProfile viewProfile = new com.projects.CIT_Version1_0.view.UserProfile();
        		System.out.println(dateTime.format(profile.getCreatedOn()));
        		System.out.println(dateTime.format(profile.getUpdatedOn()));
        		BeanUtils.copyProperties(profile, viewProfile);
        		viewProfile.setCreatedOn(dateTime.format(profile.getCreatedOn()));
        		viewProfile.setUpdatedOn(dateTime.format(profile.getUpdatedOn()));
        		profileResults.add(viewProfile);
        	}
        	return new ResponseEntity<>(profileResults, HttpStatus.OK);
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
