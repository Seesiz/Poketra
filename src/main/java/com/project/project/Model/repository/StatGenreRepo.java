package com.project.project.Model.repository;

import com.project.project.Model.StatistiqueGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatGenreRepo extends JpaRepository<StatistiqueGenre, Integer> {
}
