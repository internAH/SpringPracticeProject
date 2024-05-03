package com.example.SpringPratciceProject.service;

import com.example.SpringPratciceProject.entity.Owner;
import com.example.SpringPratciceProject.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    public Owner saveOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id){
        Optional<Owner> oId = ownerRepository.findById(id);
        if(!oId.isPresent()){
            throw new RuntimeException("Owner not found");
        }
        return oId.get();
    }

    public Owner getOwnerByName(String name){
        return ownerRepository.findByOwnerName(name);
    }

    public Owner updateOwner(Owner owner, Long id){
        Optional<Owner> oId = ownerRepository.findById(id);
        if(!oId.isPresent()){
            throw new RuntimeException("Owner not found");
        }
        Owner existingRecord =oId.get();
        if(!existingRecord.getOwnerName().equals(owner.getOwnerName())){
            existingRecord.setOwnerName(owner.getOwnerName());
        }
        return ownerRepository.save(existingRecord);
    }

    public void deleteOwner(Long id){
        ownerRepository.deleteById(id);
    }

}
