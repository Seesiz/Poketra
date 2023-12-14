package com.project.project.Model.repository;

import com.project.project.Model.Unite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniteRepo extends JpaRepository<Unite,Integer> {
    public Unite getUniteByUniId(int id);
}
