package com.service.product.api.Medicalcommerce.controller;

import com.service.product.api.Medicalcommerce.model.AppointmentEntity;
import com.service.product.api.Medicalcommerce.model.PatientEntity;
import com.service.product.api.Medicalcommerce.servicelayer.AppointmentService;
import com.service.product.api.Medicalcommerce.servicelayer.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ArrayList<AppointmentEntity> getAll(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentEntity getAppointment(@PathVariable Long id){
        return appointmentService.getAPatientById(id);
    }

    @PostMapping
    public AppointmentEntity create(@RequestBody AppointmentEntity appointment){
        return appointmentService.saveAppointment(appointment);
    }

    @PutMapping
    public AppointmentEntity update(@PathVariable Long Id, @RequestBody AppointmentEntity appointment){
        return appointmentService.updateAppointment(appointment, Id);
    }

    @DeleteMapping
    public void deleteAppointment(@PathVariable Long appointment){
        appointmentService.deleteAppointment(appointment);
    }
}
