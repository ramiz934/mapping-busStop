package com.example.controller;

import com.example.entity.Bus;
import com.example.entity.BusStops;
import com.example.entity.Stops;
import com.example.repositoty.BusRepository;
import com.example.repositoty.StopsRepository;
import com.example.service.BusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus_stop")
public class BusStopController {

    @Autowired
    private BusStopService busStopService;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private StopsRepository stopsRepository;
    @PostMapping
    public ResponseEntity<BusStops> createBusStops(@RequestParam long busId,
                                                   @RequestParam long stopId,
                                                   @RequestBody BusStops busStops){

        Bus bus = busRepository.findById(busId).get();
        Stops stops = stopsRepository.findById(stopId).get();
        busStops.setBus(bus);
        busStops.setStops(stops);
        BusStops saved = busStopService.createBusStops( busStops);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @DeleteMapping
    public  ResponseEntity<String> deleteBuStopsById(long id){
        busStopService.deleteBusStops(id);
        return new ResponseEntity<>("Record Deleted",HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<BusStops> getBusStopsById(long id){
        BusStops busStops = busStopService.getBusStopsById(id);
        return new ResponseEntity<>(busStops, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusStops>> getAllBusStops(){
        List<BusStops> busStops = busStopService.getAllBusStops();
        return new ResponseEntity<>(busStops, HttpStatus.OK);
    }
}
