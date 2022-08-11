package com.labihi.gestionecertificazioni.controller;

import com.labihi.gestionecertificazioni.entity.Certification;
import com.labihi.gestionecertificazioni.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/certification")
public class CertificationController {
    private final CertificationRepository certificationRepository;

    @RequestMapping("")
    public List<Certification> getAllCertification(){
        return certificationRepository.findAll();
    }
}
