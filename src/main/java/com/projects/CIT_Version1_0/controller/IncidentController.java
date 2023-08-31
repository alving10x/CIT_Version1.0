package com.projects.CIT_Version1_0.controller;

import java.util.List;
import java.util.Set;

import com.projects.CIT_Version1_0.TagGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projects.CIT_Version1_0.Service.IncidentService;
import com.projects.CIT_Version1_0.model.Incident;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class IncidentController {
    @Autowired
    IncidentService incidentService;

    @Autowired
    TagGenerator tagGenerator;

    @GetMapping("/getIncidents")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<com.projects.CIT_Version1_0.view.Incident>> getIncidents(){
        return incidentService.getIncidents();
    }

    @PostMapping("/addIncident")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> addIncident(@RequestBody Incident incident){

        System.out.println(incident.toString());

        return incidentService.addIncident(incident);

    }

    @GetMapping("/getIncident/{incidentId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<com.projects.CIT_Version1_0.view.Incident> getIncident(@PathVariable Long incidentId){

        return incidentService.getIncident(incidentId);
    }

}
