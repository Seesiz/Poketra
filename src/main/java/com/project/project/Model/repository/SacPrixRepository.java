package com.project.project.Model.repository;

import com.project.project.Model.SacPrix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SacPrixRepository extends JpaRepository<SacPrix, Integer> {
    public List<SacPrix> findSacPrixBySacPrixBetween(double min, double max);
}
