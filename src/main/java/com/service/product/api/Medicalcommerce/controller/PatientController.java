package com.service.product.api.Medicalcommerce.controller;

import com.service.product.api.Medicalcommerce.model.PatientEntity;
import com.service.product.api.Medicalcommerce.servicelayer.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public ArrayList<PatientEntity> getAll(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientEntity getPatient(@PathVariable Long id){
        return patientService.getAPatientById(id);
    }

    @PostMapping
    public PatientEntity create(@RequestBody PatientEntity patient){
        return patientService.saveAPatient(patient);
    }

    @PutMapping
    public PatientEntity update(@PathVariable Long Id, @RequestBody PatientEntity patient){
        return patientService.updateAPatient(patient, Id);
    }

    @DeleteMapping
    public void deletePatient(@PathVariable Long patientId){
        patientService.deleteAPatient(patientId);
    }
}
