package com.example.heartbeat.controller;

import com.example.heartbeat.service.HeartbeatSensor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {

    private final HeartbeatSensor heartbeatSensor;

    public HeartbeatController(HeartbeatSensor heartbeatSensor) {
        this.heartbeatSensor = heartbeatSensor;
    }

    @GetMapping("/heartbeat")
    public int heartbeat() {

        return heartbeatSensor.get();
    }
}