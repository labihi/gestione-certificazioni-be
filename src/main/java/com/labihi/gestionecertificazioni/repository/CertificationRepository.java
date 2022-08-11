package com.labihi.gestionecertificazioni.repository;

import com.labihi.gestionecertificazioni.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {

}
