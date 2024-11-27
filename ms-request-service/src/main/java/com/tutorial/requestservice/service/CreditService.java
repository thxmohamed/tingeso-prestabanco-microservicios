package com.tutorial.requestservice.service;

import com.tutorial.requestservice.repository.CreditRepository;
import com.tutorial.requestservice.entity.CreditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CreditService {
    @Autowired
    CreditRepository creditRepository;

    public List<CreditEntity> getCredits() {
        return creditRepository.findAll();
    }

    public CreditEntity saveCredit(CreditEntity credit) {
        if (credit == null) {
            throw new IllegalArgumentException("Credit entity cannot be null");
        }
        return creditRepository.save(credit);
    }

    public List<CreditEntity> getClientCredits(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Client ID cannot be null");
        }
        return creditRepository.findByClientID(id);
    }

    public CreditEntity findCreditByID(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return creditRepository.findById(id).orElse(null);
    }

    public void updateCreditStatus(Long id, CreditEntity.Status status) {
        if (id == null || status == null) {
            throw new IllegalArgumentException("ID or status cannot be null");
        }
        creditRepository.updateCreditStatus(id, status);
    }

    @Transactional
    public void updateObservations(Long id, String observations) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        creditRepository.updateObservations(id, observations);
    }
}