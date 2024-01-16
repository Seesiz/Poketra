package com.project.project.Model.repository;

import com.project.project.Model.Benefice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeneficeRepo extends JpaRepository<Benefice, Integer> {
    List<Benefice> findAllByBeneficeBetween(double a1, double a2);
}
