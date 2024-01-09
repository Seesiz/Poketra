package com.project.project.Model.repository;

import com.project.project.Model.Matiere;
import com.project.project.Model.SacMatiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SacMatiereRepo extends JpaRepository<SacMatiere, Integer> {
    public List<SacMatiere> getAllBySacMatiere(Matiere m);
}
