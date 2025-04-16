package com.service.product.api.Medicalcommerce.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DoctorsAddressEntity {


    public DoctorsAddressEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hospitalAddress;
    private String city;

    public DoctorsAddressEntity(String hospitalAddress, String city, String preAssignedDoctorId, Long id) {
        this.hospitalAddress = hospitalAddress;
        this.city = city;
        this.preAssignedDoctorId = preAssignedDoctorId;
        this.id = id;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPreAssignedDoctorId() {
        return preAssignedDoctorId;
    }

    public void setPreAssignedDoctorId(String preAssignedDoctorId) {
        this.preAssignedDoctorId = preAssignedDoctorId;
    }

    private String preAssignedDoctorId;
}
