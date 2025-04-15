package com.service.product.api.Medicalcommerce.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DoctorEntity {
    public DoctorEntity(Long id, String preAssignedDoctorId, String doctorsUploadedPanCardForVerificationFilePath, String city, String hospitalAddress, String specialityOfDoctor, List<String> availableTimes, List<String> currentAppointments) {
        this.id = id;
        this.preAssignedDoctorId = preAssignedDoctorId;
        this.doctorsUploadedPanCardForVerificationFilePath = doctorsUploadedPanCardForVerificationFilePath;
        this.specialityOfDoctor = specialityOfDoctor;
        this.availableTimes = availableTimes;
        this.currentAppointments = currentAppointments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String preAssignedDoctorId;
    private String doctorsUploadedPanCardForVerificationFilePath;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreAssignedDoctorId() {
        return preAssignedDoctorId;
    }

    public void setPreAssignedDoctorId(String preAssignedDoctorId) {
        this.preAssignedDoctorId = preAssignedDoctorId;
    }

    public String getDoctorsUploadedPanCardForVerificationFilePath() {
        return doctorsUploadedPanCardForVerificationFilePath;
    }

    public void setDoctorsUploadedPanCardForVerificationFilePath(String doctorsUploadedPanCardForVerificationFilePath) {
        this.doctorsUploadedPanCardForVerificationFilePath = doctorsUploadedPanCardForVerificationFilePath;
    }


    public String getSpecialityOfDoctor() {
        return specialityOfDoctor;
    }

    public void setSpecialityOfDoctor(String specialityOfDoctor) {
        this.specialityOfDoctor = specialityOfDoctor;
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<String> availableTimes) {
        this.availableTimes = availableTimes;
    }

    public List<String> getCurrentAppointments() {
        return currentAppointments;
    }

    public void setCurrentAppointments(List<String> currentAppointments) {
        this.currentAppointments = currentAppointments;
    }


    private String specialityOfDoctor;
    private List<String> availableTimes;

    @ElementCollection
    @CollectionTable(name="AppointmentBookings",
    joinColumns = @JoinColumn(name ="preAssignedDoctorId"))
    @Column(name = "appointments")
    private List<String> currentAppointments;


    public DoctorsAddressEntity getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(DoctorsAddressEntity addressDetails) {
        this.addressDetails = addressDetails;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private DoctorsAddressEntity addressDetails;

}
