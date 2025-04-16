package com.service.product.api.Medicalcommerce.repository;

import com.service.product.api.Medicalcommerce.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends JpaRepository<DoctorEntity, Long> {
}
