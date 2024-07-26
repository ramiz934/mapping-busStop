package com.example.controller;

import com.example.entity.Bus;
import com.example.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus){
        Bus  saved = busService.createBus(bus);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);

    }
}
