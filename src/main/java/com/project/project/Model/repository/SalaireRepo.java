package com.project.project.Model.repository;

import com.project.project.Model.Salaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaireRepo extends JpaRepository<Salaire, Integer> {
    public List<Salaire> findAllByNomLikeOrPrenomLike(String nom, String prenom);
}
