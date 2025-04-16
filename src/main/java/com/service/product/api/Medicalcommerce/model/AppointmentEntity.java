package com.service.product.api.Medicalcommerce.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "AppointmentBookings")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date appointmentTimeStamp;

    public AppointmentEntity(){}
    public AppointmentEntity(Long id, Date appointmentTimeStamp, Long doctorId) {
        this.id = id;
        this.appointmentTimeStamp = appointmentTimeStamp;
        this.doctorId = doctorId;
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

}
