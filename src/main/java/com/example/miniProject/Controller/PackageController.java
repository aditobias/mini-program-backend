package com.example.miniProject.Controller;


import com.example.miniProject.Sevice.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    PackageService packageService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Package> postPackage(@RequestBody Package newPackage){
        Package newPackageMade = packageService.save(newPackage);
            if(isNull(newPackageMade)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(newPackageMade,HttpStatus.CREATED);
        }
}

