package com.service.product.api.Medicalcommerce.repository;

import com.service.product.api.Medicalcommerce.model.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
