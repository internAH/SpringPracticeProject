package com.example.SpringPratciceProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringPratciceProject.entity.Department1;
import com.example.SpringPratciceProject.entity.Employee1;
import com.example.SpringPratciceProject.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add-employees")
    public Employee1 saveEmployee(@RequestBody Employee1 employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/getEmployees")
    public List<Employee1> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public Employee1 getEmployeeById(@PathVariable("id") Long empId) {
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping("/getEmployees/{name}")
    public Employee1 getEmployeeByName(@PathVariable("name") String empName) {
        return employeeService.getEmployeeByName(empName);
    }


    @PutMapping("updateEmployee/{id}")
    public Employee1 updateEmployee(@RequestBody Employee1 employee, @PathVariable Long id) {
        return employeeService.updateEmployee(employee,id);
    }

    @DeleteMapping("deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long empId) {
        employeeService.deleteEmployee(empId);
        return "Deleted Succesfully";
    }

}
