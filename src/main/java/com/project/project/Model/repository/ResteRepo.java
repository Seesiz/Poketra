package com.project.project.Model.repository;

import com.project.project.Model.Reste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResteRepo extends JpaRepository<Reste, Integer> {
    List<Reste> findAllByMatNomLike(String nom);
}
