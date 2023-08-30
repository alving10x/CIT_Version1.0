package com.projects.CIT_Version1_0.dao;

import com.projects.CIT_Version1_0.model.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncidentDao extends MongoRepository<Incident,Integer> {
}
