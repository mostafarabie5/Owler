package com.mycompany.app;

import org.springframework.web.bind.annotation.RestController;

import com.mycompany.app.Service.QueryProcessorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.bson.Document;

import java.util.*;

@RestController
public class QueryProcesssor {
    
    private QueryProcessorService service;

    public QueryProcesssor(QueryProcessorService service){
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/search")
    public ResponseEntity<List<Document>> search(@RequestBody String query) {
        return new ResponseEntity<>(service.search(query), HttpStatus.OK); 
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/suggest")
    public ResponseEntity<List<String>> getSuggestions(@RequestBody String query) {
        return new ResponseEntity<List<String>>(service.getSuggestions(query), HttpStatus.OK);
    }
    
}
