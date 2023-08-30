package com.projects.CIT_Version1_0.dao;

import com.projects.CIT_Version1_0.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserProfileDao extends MongoRepository<UserProfile,Integer> {
    @Query(value = "{}", fields = "{ 'username' : 1, 'password' : 1}")
    List<UserProfile> findAllWithSelectedColumns();

}
