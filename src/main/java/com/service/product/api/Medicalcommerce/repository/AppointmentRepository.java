package com.service.product.api.Medicalcommerce.repository;

import com.service.product.api.Medicalcommerce.model.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository  extends JpaRepository<AppointmentEntity, Long> {
}
