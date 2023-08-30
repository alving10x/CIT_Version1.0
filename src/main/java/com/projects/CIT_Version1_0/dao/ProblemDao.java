package com.projects.CIT_Version1_0.dao;

import com.projects.CIT_Version1_0.model.Problem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProblemDao extends MongoRepository<Problem, Integer> {
}
