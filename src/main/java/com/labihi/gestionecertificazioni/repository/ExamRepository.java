package com.labihi.gestionecertificazioni.repository;

import com.labihi.gestionecertificazioni.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    List<Exam> findByCertificationId(Long certificationId);

    List<Exam> findByLocation(String location);
}
