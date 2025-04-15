package com.service.product.api.Medicalcommerce.servicelayer;

import com.service.product.api.Medicalcommerce.model.AppointmentEntity;
import com.service.product.api.Medicalcommerce.model.PatientEntity;
import com.service.product.api.Medicalcommerce.repository.AppointmentRepository;
import com.service.product.api.Medicalcommerce.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public ArrayList<AppointmentEntity> getAllAppointments(){
        return (ArrayList<AppointmentEntity>) appointmentRepository.findAll();
    }

    public AppointmentEntity getAPatientById(Long id){
        return appointmentRepository.findById(id).orElse(null);
    }

    public AppointmentEntity saveAppointment(AppointmentEntity appointmentDetails){
        return appointmentRepository.save(appointmentDetails);
    }

    public AppointmentEntity updateAppointment(AppointmentEntity appointment, Long appointmentId){
        AppointmentEntity appointmentData = appointmentRepository.findById(appointmentId).orElse(null);
        if(appointmentData!=null){
            appointmentData.setDoctorId(appointment.getDoctorId());
            appointmentData.setAppointmentTimeStamp(appointment.getAppointmentTimeStamp());
            return appointmentRepository.save(appointmentData);
        }
        return null;
    }

    public void deleteAppointment(Long patientId){
        appointmentRepository.deleteById(patientId);
    }
}
