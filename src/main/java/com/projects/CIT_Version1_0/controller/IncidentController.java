package com.projects.CIT_Version1_0.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projects.CIT_Version1_0.Service.IncidentService;
import com.projects.CIT_Version1_0.model.Incident;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class IncidentController {
    @Autowired
    IncidentService incidentService;

    @GetMapping("/getIncidents")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<com.projects.CIT_Version1_0.view.Incident>> getIncidents(){
        return incidentService.getIncidents();
    }

    @PostMapping("/addIncident")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> addIncident(@RequestBody Incident incident){

        return incidentService.addIncident(incident);

    }

}
