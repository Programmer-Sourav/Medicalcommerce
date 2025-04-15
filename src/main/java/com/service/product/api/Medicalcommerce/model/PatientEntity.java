package com.service.product.api.Medicalcommerce.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PatientEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String patientName;

    public PatientEntity(Long id, String patientName, String patientPhoneNumber, String patientEmailId, ArrayList<String> diseaseHistory) {
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

    public String getPatientEmailId() {
        return patientEmailId;
    }

    public void setPatientEmailId(String patientEmailId) {
        this.patientEmailId = patientEmailId;
    }

    public ArrayList<String> getDiseaseHistory() {
        return (ArrayList<String>) diseaseHistory;
    }

    public void setDiseaseHistory(ArrayList<String> diseaseHistory) {
        this.diseaseHistory = diseaseHistory;
    }

    private String patientEmailId;
    @ElementCollection
    @CollectionTable(name="patient_diseases_table",
            joinColumns = @JoinColumn(name="patient_id"))
    @Column(name = "diseases")
    private List<String> diseaseHistory;

}
