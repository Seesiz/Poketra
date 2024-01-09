package com.project.project.Model.repository;

import com.project.project.Model.Matiere_Look;
import com.project.project.Model.QuantiteM;
import com.project.project.Model.Taille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantiteRepo extends JpaRepository<QuantiteM, Integer> {
    public QuantiteM getByQuanMatiereLookAndQuanTaille(Matiere_Look mat, Taille taille);
}
