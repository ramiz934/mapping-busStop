package com.example.controller;

import com.example.entity.Stops;
import com.example.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stops")
public class StopsController {

    @Autowired
    private StopService stopService;

    @PostMapping
    public ResponseEntity<Stops> createStops(@RequestBody Stops stops){
        Stops ceated = stopService.ceateStops(stops);
        return new ResponseEntity<Stops>(ceated, HttpStatus.CREATED);
    }
}
