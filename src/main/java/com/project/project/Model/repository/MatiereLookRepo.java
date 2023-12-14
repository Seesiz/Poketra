package com.project.project.Model.repository;

import com.project.project.Model.Look;
import com.project.project.Model.Matiere_Look;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatiereLookRepo extends JpaRepository<Matiere_Look, Integer> {
    public List<Matiere_Look> getAllByMatdetLook(Look l);
}
