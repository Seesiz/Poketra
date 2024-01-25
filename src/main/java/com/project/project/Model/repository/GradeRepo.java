package com.project.project.Model.repository;

import com.project.project.Model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GradeRepo extends JpaRepository<Grade, Integer> {
    public Grade getByTaux(double taux);
}
