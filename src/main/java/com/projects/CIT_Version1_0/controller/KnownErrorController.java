package com.projects.CIT_Version1_0.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projects.CIT_Version1_0.Service.KnownErrorService;
import com.projects.CIT_Version1_0.model.KnownError;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class KnownErrorController {

    @Autowired
    KnownErrorService  knownErrorService;

    @GetMapping("/getKnownErrors")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<KnownError>> getKnownErrors(){
        return knownErrorService.getKnownErrors();
    }

    @PostMapping("/addKnownError")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> addKnownError(@RequestBody KnownError knownError) {

        return knownErrorService.addKnownError(knownError);
    }
}
