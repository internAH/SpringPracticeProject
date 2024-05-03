package com.example.SpringPratciceProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.SpringPratciceProject.entity.Department1;
import com.example.SpringPratciceProject.entity.Employee1;
import com.example.SpringPratciceProject.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee1 saveEmployee(Employee1 employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee1> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee1 getEmployeeById(Long empId) {
        Optional<Employee1> employee = employeeRepository.findById(empId);

        if(!employee.isPresent()) {
            throw new RuntimeException("Employee record not found");
        }
        return employee.get();
    }

    public Employee1 getEmployeeByName(String empName) {
        return employeeRepository.findByEmployeeName(empName);
    }


    public Employee1 updateEmployee(Employee1 emp, Long empId) {
        Optional<Employee1> employee = employeeRepository.findById(empId);
        if(!employee.isPresent()) {
            throw new RuntimeException("Employee Record not found");
        }
        Employee1 existingEmpRecord = employee.get();
        if(!existingEmpRecord.getEmployeeName().equals(emp.getEmployeeName())) {
            existingEmpRecord.setEmployeeName(emp.getEmployeeName());
        }
        if(!existingEmpRecord.getEmployeeDepartment().equals(emp.getEmployeeDepartment())) {
            existingEmpRecord.setEmployeeDepartment(emp.getEmployeeDepartment());
        }
        if(!existingEmpRecord.getEmployeeEmailAddress().equals(emp.getEmployeeEmailAddress())) {
            existingEmpRecord.setEmployeeEmailAddress(emp.getEmployeeEmailAddress());
        }
        if(existingEmpRecord.getEmployeeExperience()!=(emp.getEmployeeExperience())) {
            existingEmpRecord.setEmployeeExperience(emp.getEmployeeExperience());
        }
        if(!existingEmpRecord.getEmployeeMobileNumber().equals(emp.getEmployeeMobileNumber())) {
            existingEmpRecord.setEmployeeMobileNumber(emp.getEmployeeMobileNumber());
        }
        if(!existingEmpRecord.getEmployeeSalary().equals(emp.getEmployeeSalary())) {
            existingEmpRecord.setEmployeeSalary(emp.getEmployeeSalary());
        }
        return employeeRepository.save(existingEmpRecord);

    }

    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }



}
