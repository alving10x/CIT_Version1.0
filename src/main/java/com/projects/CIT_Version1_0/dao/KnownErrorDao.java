package com.projects.CIT_Version1_0.dao;

import com.projects.CIT_Version1_0.model.KnownError;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KnownErrorDao extends MongoRepository<KnownError, Integer> {
}
