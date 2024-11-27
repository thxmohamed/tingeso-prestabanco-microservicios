package com.tutorial.simulate.service;

import com.tutorial.simulate.repository.SimulateRepository;
import com.tutorial.simulate.entity.SimulateEntity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class SimulateService {
    @Autowired
    SimulateRepository simulateRepository;

    public double creditSimulate(SimulateEntity credit) {
        if (credit == null || credit.getInterestRate() <= 0 || credit.getYearsLimit() <= 0 || credit.getRequestedAmount() <= 0) {
            throw new IllegalArgumentException("Invalid credit data for simulation");
        }
        double interest = credit.getInterestRate() / 12 / 100;
        int months = credit.getYearsLimit() * 12;
        double amount = credit.getRequestedAmount();
        return (amount * interest * Math.pow((1 + interest), months)) / (Math.pow(1 + interest, months) - 1);
    }
}

