package com.service.product.api.Medicalcommerce.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class PatientEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String patientName;

    public PatientEntity(Long id, String patientName, String patientPhoneNumber, Long patientEmailId, ArrayList<String> diseaseHistory) {
        this.id = id;
        this.patientName = patientName;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientEmailId = patientEmailId;
        this.diseaseHistory = diseaseHistory;
    }

    private String patientPhoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public Long getPatientEmailId() {
        return patientEmailId;
    }

    public void setPatientEmailId(Long patientEmailId) {
        this.patientEmailId = patientEmailId;
    }

    public ArrayList<String> getDiseaseHistory() {
        return diseaseHistory;
    }

    public void setDiseaseHistory(ArrayList<String> diseaseHistory) {
        this.diseaseHistory = diseaseHistory;
    }

    private Long patientEmailId;
    private ArrayList<String> diseaseHistory;

}
