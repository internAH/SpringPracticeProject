package com.example.SpringPratciceProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringPratciceProject.entity.Department1;

@Repository
public interface DepartmentRepository extends JpaRepository<Department1, Long> {
    public Department1 findByDepartmentName(String departmentName);

}
