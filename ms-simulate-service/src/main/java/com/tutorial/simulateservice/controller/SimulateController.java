package com.tutorial.simulateservice.controller;


import com.tutorial.simulateservice.entity.CreditEntity;
import com.tutorial.simulateservice.service.SimulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulate")
@CrossOrigin("*")
public class SimulateController {

    @Autowired
    SimulateService simulateService;

    @PostMapping("")
    public ResponseEntity<Double> simulateCredit(@RequestBody CreditEntity credit) {
        double monthlyPayment = simulateService.creditSimulate(credit);
        return ResponseEntity.ok(monthlyPayment);
    }
}
