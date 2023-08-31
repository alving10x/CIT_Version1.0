package com.projects.CIT_Version1_0.dao;

import com.projects.CIT_Version1_0.model.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface IncidentDao extends MongoRepository<Incident,Integer> {
    Incident findByIncidentId(Long incidentId);
}
