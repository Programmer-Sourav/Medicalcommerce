package com.service.product.api.Medicalcommerce.servicelayer;

import com.service.product.api.Medicalcommerce.model.PatientEntity;
import com.service.product.api.Medicalcommerce.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public ArrayList<PatientEntity> getAllPatients(){
        return (ArrayList<PatientEntity>) patientRepository.findAll();
    }

    public PatientEntity getAPatientById(Long id){
        return patientRepository.findById(id).orElse(null);
    }

    public PatientEntity saveAPatient(PatientEntity patient){
        return patientRepository.save(patient);
    }

    public PatientEntity updateAPatient(PatientEntity patient, Long patientId){
        PatientEntity patientData = patientRepository.findById(patientId).orElse(null);
        if(patientData!=null){
            patientData.setPatientPhoneNumber(patient.getPatientName());
            patientData.setDiseaseHistory(patient.getDiseaseHistory());
            return patientRepository.save(patientData);
        }
        return null;
    }

    public void deleteAPatient(Long patientId){
        patientRepository.deleteById(patientId);
    }
}
