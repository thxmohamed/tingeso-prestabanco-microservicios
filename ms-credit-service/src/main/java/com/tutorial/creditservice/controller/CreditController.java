package com.tutorial.creditservice.controller;


import com.tutorial.creditservice.entity.CreditEntity;
import com.tutorial.creditservice.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit")
@CrossOrigin("*")
public class CreditController {
    @Autowired
    CreditService creditService;
    @GetMapping("/")
    public ResponseEntity<List<CreditEntity>> listCredits(){
        List<CreditEntity> credits = creditService.getCredits();
        return ResponseEntity.ok(credits);
    }

    @PostMapping("/save")
    public ResponseEntity<CreditEntity> saveCredit(@RequestBody CreditEntity credit){
        return ResponseEntity.ok(creditService.saveCredit(credit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CreditEntity>> listCreditDocuments(@PathVariable Long id){
        List<CreditEntity> credits = creditService.getClientCredits(id);
        return ResponseEntity.ok(credits);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CreditEntity> getByID(@PathVariable Long id){
        CreditEntity credit = creditService.findCreditByID(id);
        return ResponseEntity.ok(credit);
    }
    @PostMapping("/simulate")
    public ResponseEntity<Double> simulateCredit(@RequestBody CreditEntity credit) {
        double monthlyPayment = creditService.creditSimulate(credit);
        return ResponseEntity.ok(monthlyPayment);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateCreditStatus(@PathVariable Long id, @RequestBody CreditEntity.Status status) {
        creditService.updateCreditStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/observations")
    public ResponseEntity<String> updateObservations(@PathVariable Long id, @RequestBody String observations) {
        try {
            creditService.updateObservations(id, observations);
            return ResponseEntity.ok("Observations updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update observations.");
        }
    }
}