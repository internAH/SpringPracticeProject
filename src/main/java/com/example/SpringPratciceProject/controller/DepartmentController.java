package com.example.SpringPratciceProject.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringPratciceProject.entity.Department1;
import com.example.SpringPratciceProject.service.DepartmentService;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add-departments")
    public Department1 saveDepartment(@RequestBody Department1 department) {

        return departmentService.saveDepartment(department);

    }

    @GetMapping("/getDepartments")
    public List<Department1> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/getDepartments/{id}")
    public Department1 getDepartment(@PathVariable("id") Long deptId) {
        return departmentService.getDepartment(deptId);
    }

    @GetMapping("/getDepartmentByName/{name}")
    public Department1 getDepartmentByName(@PathVariable("name") String deptName) {
        return departmentService.getDepartmentByName(deptName);
    }

    @PutMapping("/updateDepartmentData/{deptId}")
    public Department1 updateDepartment(@RequestBody Department1 department, @PathVariable("deptId") Long deptId) {
        return departmentService.updateDepartment(department,deptId);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable("id")Long deptId) {
        departmentService.deleteDepartment(deptId);
        return "Deleted Succesfully";

    }

}
