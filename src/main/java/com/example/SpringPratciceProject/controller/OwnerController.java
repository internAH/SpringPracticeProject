package com.example.SpringPratciceProject.controller;

import com.example.SpringPratciceProject.entity.Owner;
import com.example.SpringPratciceProject.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @PostMapping("/add-owner")
    public Owner saveOwner(@RequestBody Owner owner){
        return ownerService.saveOwner(owner);
    }

    @GetMapping("/getOwners")
    public List<Owner> getAllOwners(){
        return ownerService.getAllOwners();
    }

    @GetMapping("/getOwner/{id}")
    public Owner getOwnerById(@PathVariable("id") Long oId){
        return ownerService.getOwnerById(oId);
    }

    @GetMapping("/getOwnerByName/{name}")
    public Owner getOwnerByName(@PathVariable("name") String oName){
        return ownerService.getOwnerByName(oName);
    }

    @PostMapping("/updateOwnerData/{id}")
    public Owner updateOwner(@RequestBody Owner owner, @PathVariable("id") Long oId){
        return ownerService.updateOwner(owner, oId);
    }

    @DeleteMapping("/deleteOwner/{id}")
    public String deleteOwner(@PathVariable("id") Long oId){
        ownerService.deleteOwner(oId);
        return "Deleted Successfully";
    }
}
