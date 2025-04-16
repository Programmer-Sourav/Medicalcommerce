package com.service.product.api.Medicalcommerce.model;

import jakarta.persistence.*;

import java.util.Date;

/***
 * Patient will create Appointments, So OneToMany in PatientEntity makes sense
 * Doctors will also access AppointmentEntity. They can have a List of AppointmentEntity.
 * So, OneToMany in DoctorEntity makes sense.
 * We are using ManyToOne Relationship in Appointments entity to allow Bi-directional Communication
 * and it will also help us to retrieve the nested data with appointment details easily.
 *
 *
 */
@Entity
//@Table(name = "AppointmentBookings")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date appointmentTimeStamp;

    public AppointmentEntity(){}
    public AppointmentEntity(Long id, Date appointmentTimeStamp, Long doctorId, Long patientId) {
        this.id = id;
        this.appointmentTimeStamp = appointmentTimeStamp;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAppointmentTimeStamp() {
        return appointmentTimeStamp;
    }

    public void setAppointmentTimeStamp(Date appointmentTimeStamp) {
        this.appointmentTimeStamp = appointmentTimeStamp;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    private Long doctorId;
    private Long patientId;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }


    @ManyToOne
    @JoinColumn(name = "preAssignedDoctorId", insertable = false, updatable = false)
    private DoctorEntity doctorEntity;

    @ManyToOne
    @JoinColumn(name = "patientId", insertable = false, updatable = false)
    private PatientEntity patientEntity;
}
