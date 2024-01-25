package com.project.project.Model.repository;

import com.project.project.Model.Travailleur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravailleurRepo extends JpaRepository<Travailleur, Integer> {
}
