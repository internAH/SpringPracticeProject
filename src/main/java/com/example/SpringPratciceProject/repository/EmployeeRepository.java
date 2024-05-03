package com.example.SpringPratciceProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringPratciceProject.entity.Employee1;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee1, Long>{
    public Employee1 findByEmployeeName(String empName);



}
