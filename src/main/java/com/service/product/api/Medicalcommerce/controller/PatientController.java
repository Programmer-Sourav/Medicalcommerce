package com.service.product.api.Medicalcommerce.controller;

import com.service.product.api.Medicalcommerce.API.ApiResponse;
import com.service.product.api.Medicalcommerce.model.PatientEntity;
import com.service.product.api.Medicalcommerce.servicelayer.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/allPatients")
    public ResponseEntity<ApiResponse<PatientEntity>> getAll(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PatientEntity>> getPatient(@PathVariable Long id){
        return patientService.getAPatientById(id);
    }

    @PostMapping("/add_patient")
    public ResponseEntity<ApiResponse<PatientEntity>> create(@RequestBody PatientEntity patient){
        return patientService.saveAPatient(patient);
    }

    @PutMapping("/update_patient/{Id}")
    public ResponseEntity<ApiResponse<PatientEntity>> update(@PathVariable String Id, @RequestBody PatientEntity patient){
        System.out.print("Path Variable "+ Id);
        return patientService.updateAPatient(patient, Id);
    }

    @DeleteMapping("delete_patient")
    public void deletePatient(@PathVariable Long patientId){
        patientService.deleteAPatient(patientId);
    }
}
