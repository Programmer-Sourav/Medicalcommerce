package com.service.product.api.Medicalcommerce.servicelayer;

import com.service.product.api.Medicalcommerce.API.ApiResponse;
import com.service.product.api.Medicalcommerce.model.PatientEntity;
import com.service.product.api.Medicalcommerce.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public ResponseEntity<ApiResponse<PatientEntity>> getAllPatients(){
        try {
            List<PatientEntity> allPatients = patientRepository.findAll();
            ApiResponse<PatientEntity> response = new ApiResponse<>(200, "Patient Added Successfully!", null,  allPatients);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            ApiResponse<PatientEntity> errorResponse = new ApiResponse<>(500, "Failed to add patient", null, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    public ResponseEntity<ApiResponse<PatientEntity>> getAPatientById(Long id){
        try {
            PatientEntity individualPatientData = patientRepository.findById(id).orElse(null);
            ApiResponse<PatientEntity> response = new ApiResponse<>(200, "Patient Added Successfully!",  individualPatientData, null);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            ApiResponse<PatientEntity> errorResponse = new ApiResponse<>(500, "Failed to add patient", null, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

    }

    public ResponseEntity<ApiResponse<PatientEntity>> saveAPatient(PatientEntity patient){
        try {
            PatientEntity savedPatient = patientRepository.save(patient);
            ApiResponse<PatientEntity> response = new ApiResponse<>(200, "Patient Added Successfully!", savedPatient, null);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            ApiResponse<PatientEntity> errorResponse = new ApiResponse<>(500, "Failed to add patient", null, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    public ResponseEntity<ApiResponse<PatientEntity>> updateAPatient(PatientEntity patient, String patientId){
        PatientEntity patientData = patientRepository.findById(Long.valueOf(patientId)).orElse(null);
        try {
            if(patientData!=null) {
                patientData.setPatientPhoneNumber(patient.getPatientName());
                patientData.setDiseaseHistory(patient.getDiseaseHistory());
                PatientEntity savedPatient = patientRepository.save(patient);
                ApiResponse<PatientEntity> response = new ApiResponse<>(200, "Patient Updated Successfully!", savedPatient, null);
                return ResponseEntity.ok(response);
            }
        }
        catch (Exception e){
            ApiResponse<PatientEntity> errorResponse = new ApiResponse<>(500, "Failed to add patient", null, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

        return null;
    }

    public void deleteAPatient(Long patientId){
        patientRepository.deleteById(patientId);
    }
}
