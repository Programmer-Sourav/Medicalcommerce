package com.service.product.api.Medicalcommerce.controller;


import com.service.product.api.Medicalcommerce.API.ApiResponse;
import com.service.product.api.Medicalcommerce.model.DoctorEntity;
import com.service.product.api.Medicalcommerce.servicelayer.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {
    @Autowired
    private DoctorsService doctorService;

    @GetMapping("/all_doctors")
    public ResponseEntity<ApiResponse<DoctorEntity>> getAll(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DoctorEntity>> getPatient(@PathVariable Long id){
        return doctorService.getADoctorById(id);
    }

    @PostMapping("/add_doctor")
    public ResponseEntity<ApiResponse<DoctorEntity>> create(@RequestBody DoctorEntity patient){
        return doctorService.saveADoctor(patient);
    }

    @PutMapping("/update_doctor/{Id}")
    public ResponseEntity<ApiResponse<DoctorEntity>> update(@PathVariable String Id, @RequestBody DoctorEntity patient){
        System.out.print("Path Variable "+ Id);
        return doctorService.updateAPatient(patient, Id);
    }

    @DeleteMapping("/delete_doctor")
    public void deleteDoctor(@PathVariable Long patientId){
        doctorService.deleteADoctor(patientId);
    }

}
