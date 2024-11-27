package com.tutorial.simulate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.tutorial.simulate.entity.SimulateEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulateRepository extends JpaRepository<SimulateEntity, Long> {

}

