package com.tutorial.tracking.service;

import com.tutorial.tracking.clients.CreditClient;
import com.tutorial.tracking.entity.CreditEntity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class TrackService {
    @Autowired
    CreditClient creditClient;

    public List<CreditEntity> getClientCredits(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Client ID cannot be null");
        }
        return creditClient.getCreditByUserId(id);
    }

    public CreditEntity getCreditById(Long id) {
        return creditClient.getCreditById(id);
    }

}

