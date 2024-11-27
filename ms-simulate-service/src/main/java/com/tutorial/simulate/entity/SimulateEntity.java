package com.tutorial.simulate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Simulate")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SimulateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int requestedAmount;
    private int yearsLimit;
    private double interestRate;
}
