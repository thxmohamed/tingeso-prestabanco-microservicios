package com.tutorial.simulateservice.service;

import com.tutorial.simulateservice.repository.CreditRepository;
import com.tutorial.simulateservice.entity.CreditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class SimulateService {
    @Autowired
    CreditRepository creditRepository;
    @Autowired
    RestTemplate restTemplate;

    public double creditSimulate(CreditEntity credit) {
        if (credit == null || credit.getInterestRate() <= 0 || credit.getYearsLimit() <= 0 || credit.getRequestedAmount() <= 0) {
            throw new IllegalArgumentException("Invalid credit data for simulation");
        }
        double interest = credit.getInterestRate() / 12 / 100;
        int months = credit.getYearsLimit() * 12;
        float amount = credit.getRequestedAmount();
        return (amount * interest * Math.pow((1 + interest), months)) / (Math.pow(1 + interest, months) - 1);
    }
}