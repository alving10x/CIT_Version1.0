package com.projects.CIT_Version1_0.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projects.CIT_Version1_0.dao.IncidentDao;
import com.projects.CIT_Version1_0.model.Incident;

@Service
public class IncidentService {

    @Autowired
    IncidentDao incidentDao;

    public ResponseEntity<List<com.projects.CIT_Version1_0.view.Incident>> getIncidents() {
        try {
        	SimpleDateFormat dateTime = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz");
        	List<Incident> incidents = incidentDao.findAll();
        	List<com.projects.CIT_Version1_0.view.Incident> incidentResults = new ArrayList<com.projects.CIT_Version1_0.view.Incident>();
        	for(Incident incident : incidents) {
        		com.projects.CIT_Version1_0.view.Incident viewInc = new com.projects.CIT_Version1_0.view.Incident();
        		System.out.println(dateTime.format(incident.getDueDate()));
        		System.out.println(dateTime.format(incident.getResolvedDate()));
        		BeanUtils.copyProperties(incident, viewInc);
        		viewInc.setDueDate(dateTime.format(incident.getDueDate()));
        		viewInc.setResolvedDate(dateTime.format(incident.getResolvedDate()));
        		incidentResults.add(viewInc);
        	}
            return new ResponseEntity<>(incidentResults, HttpStatus.OK);

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

