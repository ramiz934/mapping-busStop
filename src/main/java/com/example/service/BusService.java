package com.example.service;

import com.example.entity.Bus;
import com.example.repositoty.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;


    public Bus createBus(Bus bus) {
        Bus saved = busRepository.save(bus);
        return saved;
    }
}
