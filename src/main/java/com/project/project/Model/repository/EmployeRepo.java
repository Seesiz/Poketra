package com.project.project.Model.repository;

import com.project.project.Model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepo extends JpaRepository<Employe,Integer> {
}
