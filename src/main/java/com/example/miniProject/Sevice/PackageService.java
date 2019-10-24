package com.example.miniProject.Sevice;


import com.example.miniProject.Repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    @Autowired
    PackageRepository packageRepository;


     public Package save(Package newPackage){
         return packageRepository.save(newPackage);
     }
}
