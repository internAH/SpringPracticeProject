package com.example.SpringPratciceProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    public String employeeDepartment;
    public String employeeName;
    public float employeeExperience;
    public Double employeeSalary;
    public String employeeMobileNumber;
    public String employeeEmailAddress;

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }
    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public float getEmployeeExperience() {
        return employeeExperience;
    }
    public void setEmployeeExperience(Float employeeExperience) {
        this.employeeExperience = employeeExperience;
    }
    public Double getEmployeeSalary() {
        return employeeSalary;
    }
    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
    public String getEmployeeMobileNumber() {
        return employeeMobileNumber;
    }
    public void setEmployeeMobileNumber(String employeeMobileNumber) {
        this.employeeMobileNumber = employeeMobileNumber;
    }
    public String getEmployeeEmailAddress() {
        return employeeEmailAddress;
    }
    public void setEmployeeEmailAddress(String employeeEmailAddress) {
        this.employeeEmailAddress = employeeEmailAddress;
    }


}
