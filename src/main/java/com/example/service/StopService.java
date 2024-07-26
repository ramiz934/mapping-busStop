package com.example.service;

import com.example.entity.Stops;
import com.example.repositoty.StopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StopService {
    @Autowired
    private StopsRepository stopsRepository;

    public Stops ceateStops(Stops stops) {
        Stops saved = stopsRepository.save(stops);
        return saved;
    }
}
