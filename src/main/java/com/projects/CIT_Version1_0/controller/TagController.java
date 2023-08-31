package com.projects.CIT_Version1_0.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.projects.CIT_Version1_0.TagGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class TagController {

    @Autowired
    TagGenerator tagGenerator;
    @PostMapping("/generateTags")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Set<String>> generateTags (@RequestBody String desc) {
        Set<String> tags = tagGenerator.generateTags(desc);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }
}
