package com.example.SpringPratciceProject.repository;

import com.example.SpringPratciceProject.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {
    public Owner findByOwnerName(String name);
}
