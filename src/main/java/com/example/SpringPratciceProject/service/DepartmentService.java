package com.example.SpringPratciceProject.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.id.enhanced.DatabaseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.SpringPratciceProject.entity.Department1;
import com.example.SpringPratciceProject.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;



    public Department1 saveDepartment(Department1 department) {
        return departmentRepository.save(department);

    }

    public List<Department1> getAllDepartments(){
        return departmentRepository.findAll();

    }

    public Department1 getDepartment(Long departmentId) {
        Optional<Department1> department= departmentRepository.findById(departmentId);
        if(!department.isPresent()) {
            throw new RuntimeException("Department not found");
        }
        return department.get();
    }
    public Department1 getDepartmentByName(String deptName) {
        return departmentRepository.findByDepartmentName(deptName);
    }

    public Department1 updateDepartment(Department1 dept,Long deptId) {
        Optional<Department1> department =departmentRepository.findById(deptId);
        if(!department.isPresent()) {
            throw new RuntimeException("Department does not exist");
        }
        Department1 existingDbRecord =department.get();
        if(!existingDbRecord.getDepartmentName().equals(dept.getDepartmentName())) {
            existingDbRecord.setDepartmentName(dept.getDepartmentName());
        }
        if(!existingDbRecord.getDepartmentAddress().equals(dept.getDepartmentAddress())) {
            existingDbRecord.setDepartmentAddress(dept.getDepartmentAddress());
        }
        return departmentRepository.save(existingDbRecord);
    }

    public void deleteDepartment(Long deptId){
        departmentRepository.deleteById(deptId);
    }


}
