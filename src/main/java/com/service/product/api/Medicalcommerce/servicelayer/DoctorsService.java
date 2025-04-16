package com.service.product.api.Medicalcommerce.servicelayer;

import com.service.product.api.Medicalcommerce.API.ApiResponse;
import com.service.product.api.Medicalcommerce.model.DoctorEntity;
import com.service.product.api.Medicalcommerce.model.PatientEntity;
import com.service.product.api.Medicalcommerce.repository.DoctorsRepository;
import com.service.product.api.Medicalcommerce.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.print.Doc;
import java.util.List;

public class DoctorsService {
    @Autowired
    DoctorsRepository doctorsRepository;

    public ResponseEntity<ApiResponse<DoctorEntity>> getAllDoctors(){
        try {
            List<DoctorEntity> allDoctors = doctorsRepository.findAll();
            ApiResponse<DoctorEntity> response = new ApiResponse<>(200, "Doctors List Available!", null,  allDoctors);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            ApiResponse<DoctorEntity> errorResponse = new ApiResponse<>(500, "Failed to get Doctor's List", null, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    public ResponseEntity<ApiResponse<DoctorEntity>> getADoctorById(Long id){
        try {
            DoctorEntity individualPatientData = doctorsRepository.findById(id).orElse(null);
            ApiResponse<DoctorEntity> response = new ApiResponse<>(200, "Patient Added Successfully!",  individualPatientData, null);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            ApiResponse<DoctorEntity> errorResponse = new ApiResponse<>(500, "Failed to add patient", null, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

    }

    public ResponseEntity<ApiResponse<DoctorEntity>> saveADoctor(DoctorEntity patient){
        try {
            DoctorEntity savedPatient = doctorsRepository.save(patient);
            ApiResponse<DoctorEntity> response = new ApiResponse<>(200, "Patient Added Successfully!", savedPatient, null);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            ApiResponse<DoctorEntity> errorResponse = new ApiResponse<>(500, "Failed to add patient", null, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    public ResponseEntity<ApiResponse<DoctorEntity>> updateAPatient(DoctorEntity patient, String patientId){
        DoctorEntity patientData = doctorsRepository.findById(Long.valueOf(patientId)).orElse(null);
        try {
            if(patientData!=null) {
                patientData.setAddressDetails(patient.getAddressDetails());
                patientData.setAvailableTimes(patient.getAvailableTimes());
                patientData.setSpecialityOfDoctor(patient.getSpecialityOfDoctor());
                DoctorEntity savedPatient = doctorsRepository.save(patient);
                ApiResponse<DoctorEntity> response = new ApiResponse<>(200, "Patient Updated Successfully!", savedPatient, null);
                return ResponseEntity.ok(response);
            }
        }
        catch (Exception e){
            ApiResponse<DoctorEntity> errorResponse = new ApiResponse<>(500, "Failed to add patient", null, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

        return null;
    }

    public void deleteADoctor(Long doctorId){
        doctorsRepository.deleteById(doctorId);
    }
}
