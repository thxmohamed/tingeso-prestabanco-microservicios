package com.tutorial.simulate.controller;

import com.tutorial.simulate.entity.SimulateEntity;
import com.tutorial.simulate.service.SimulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulate")
@CrossOrigin("*")
public class UserController {

    @Autowired
    SimulateService simulateService;

    @PostMapping("")
    public ResponseEntity<Double> simulateCredit(@RequestBody SimulateEntity credit) {
        double monthlyPayment = simulateService.creditSimulate(credit);
        return ResponseEntity.ok(monthlyPayment);
    }
}
