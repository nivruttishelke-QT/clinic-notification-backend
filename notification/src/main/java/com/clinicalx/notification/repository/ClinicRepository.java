package com.clinicalx.notification.repository;

import com.clinicalx.notification.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClinicRepository extends JpaRepository<Clinic, Long> {

    List<Clinic> findByClientIdAndActiveTrue(Long clientId);
}