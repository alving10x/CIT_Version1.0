package com.projects.CIT_Version1_0.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projects.CIT_Version1_0.Service.ProblemService;
import com.projects.CIT_Version1_0.model.Problem;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProblemController {
    @Autowired
    ProblemService problemService;

    @GetMapping("/getProblems")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Problem>> getProblems(){
        return problemService.getProblems();
    }

    @PostMapping("/addProblem")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> addProblem(@RequestBody Problem problem){

        return problemService.addProblem(problem);
    }
}
