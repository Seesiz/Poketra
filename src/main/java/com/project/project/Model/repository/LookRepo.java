package com.project.project.Model.repository;

import com.project.project.Model.Look;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LookRepo extends JpaRepository<Look, Integer> {
    public Look getLookByLookId(int id);
}
