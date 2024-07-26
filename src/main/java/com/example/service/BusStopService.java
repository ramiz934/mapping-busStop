package com.example.service;

import com.example.entity.Bus;
import com.example.entity.BusStops;
import com.example.entity.Stops;
import com.example.repositoty.BusRepository;
import com.example.repositoty.BusStopsRepository;
import com.example.repositoty.StopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BusStopService {

    @Autowired
    private BusStopsRepository busStopsRepository;



    public BusStops createBusStops( BusStops busStops) {
        BusStops saved = busStopsRepository.save(busStops);
        return saved;
    }
          @Transactional
    public void deleteBusStops(long id){
        busStopsRepository.deleteById(id);
    }

    public BusStops getBusStopsById(long id) {
        BusStops busStops = busStopsRepository.findById(id).get();
        return busStops;
    }

    public List<BusStops> getAllBusStops() {
        List<BusStops> all = busStopsRepository.findAll();
        return all;
    }
}
