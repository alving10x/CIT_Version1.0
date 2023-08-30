package com.projects.CIT_Version1_0.Service;

import com.projects.CIT_Version1_0.dao.KnownErrorDao;
import com.projects.CIT_Version1_0.model.KnownError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KnownErrorService {

    @Autowired
    KnownErrorDao knownErrorDao;
    public ResponseEntity<List<KnownError>> getKnownErrors() {
        try {
            return new ResponseEntity<>(knownErrorDao.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addKnownError(KnownError knownError) {

        try {
            knownErrorDao.save(knownError);
            return new ResponseEntity<>( HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }
}
