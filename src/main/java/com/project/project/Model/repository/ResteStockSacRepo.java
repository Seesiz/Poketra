package com.project.project.Model.repository;

import com.project.project.Model.ResteStockSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ResteStockSacRepo extends JpaRepository<ResteStockSac, Integer> {
    public List<ResteStockSac> findAllBySacNomLike(String nom);
}
