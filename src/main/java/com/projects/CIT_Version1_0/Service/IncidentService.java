package com.projects.CIT_Version1_0.Service;

import com.projects.CIT_Version1_0.dao.IncidentDao;
import com.projects.CIT_Version1_0.model.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentService {

    @Autowired
    IncidentDao incidentDao;

    public ResponseEntity<List<Incident>> getIncidents() {
        try {
            return new ResponseEntity<>(incidentDao.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addIncident(Incident incident) {
        try {
            incidentDao.save(incident);
            return new ResponseEntity<>( HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }

}

