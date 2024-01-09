package com.project.project.Model.repository;

import com.project.project.Model.PrixMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrixMatiereRepo extends JpaRepository<PrixMatiere, Integer> {
    @Query(value = "WITH nr AS(SELECT *, ROW_NUMBER() OVER (PARTITION BY prix_matiere_mat_id ORDER BY prix_date DESC) as rn FROM Prix_Matiere) SELECT prix_mat_id, prix_date, prix_value, prix_matiere_mat_id FROM nr WHERE rn = 1", nativeQuery = true)
    public List<PrixMatiere> getAllLastPrixMatiere();
}
