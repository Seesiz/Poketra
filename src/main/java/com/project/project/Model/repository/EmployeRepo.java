package com.project.project.Model.repository;

import com.project.project.Model.Employe;
import com.project.project.Model.Sac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeRepo extends JpaRepository<Employe,Integer> {
    public List<Employe> findAllBySacEmploye(Sac sac);
}
