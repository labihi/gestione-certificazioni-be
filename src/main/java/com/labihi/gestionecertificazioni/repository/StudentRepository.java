package com.labihi.gestionecertificazioni.repository;

import com.labihi.gestionecertificazioni.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
