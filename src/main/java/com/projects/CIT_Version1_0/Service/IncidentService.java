package com.projects.CIT_Version1_0.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.projects.CIT_Version1_0.TagGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import com.projects.CIT_Version1_0.dao.IncidentDao;
import com.projects.CIT_Version1_0.model.Incident;

@Service
public class IncidentService {

    @Autowired
    IncidentDao incidentDao;
    @Autowired
    TagGenerator tagGenerator;

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

            Long incidentId = incident.getIncidentId();
            Incident findIncidentById = incidentDao.findByIncidentId(incidentId);

            if (findIncidentById == null){
                incidentDao.save(incident);
                return new ResponseEntity<>( HttpStatus.CREATED);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("IncidientId already exists",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<com.projects.CIT_Version1_0.view.Incident> getIncident(Long incidentId) {

        try {
            Incident incident =  incidentDao.findByIncidentId(incidentId);
            if(incident == null){
                System.out.println("null");
            }
            if (incident.getTags() == null || incident.getTags().isEmpty()){
                String description = incident.getDescription();
                Set<String> tags = tagGenerator.generateTags(description);
                System.out.println(tags);

                incident.setTags(tags);
                System.out.println(incident.getIncidentId());
                System.out.println("tags in incident = " +incident.getTags());
                incidentDao.save(incident);
                Incident incident1 = incidentDao.findByIncidentId(incidentId);
                com.projects.CIT_Version1_0.view.Incident viewIncident = new com.projects.CIT_Version1_0.view.Incident();
                BeanUtils.copyProperties(incident1, viewIncident);
                Set<String> viewTags = new HashSet<>();
//                for (String tag : incident1.getTags()){
//                    viewTags.add(tag);
//                }
 //                   viewIncident.setTags(viewTags);

                System.out.println(viewIncident.toString());
                System.out.println(" model="+ incident1.toString());


            }else {
                System.out.println("tags already generated");
                System.out.println(incident.getTags());
            }

            return new ResponseEntity<com.projects.CIT_Version1_0.view.Incident>
                    ( HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }
}

