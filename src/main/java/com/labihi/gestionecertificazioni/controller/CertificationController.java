package com.labihi.gestionecertificazioni.controller;

import com.labihi.gestionecertificazioni.entity.Certification;
import com.labihi.gestionecertificazioni.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequiredArgsConstructor
@RequestMapping("/certification")
public class CertificationController {
    private final CertificationRepository certificationRepository;

    @RequestMapping("")
    public List<Certification> getAllCertification(){
        return certificationRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Certification getCertification(@PathVariable Long id){
        return certificationRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "", method = POST)
    public Certification createCertification(@RequestBody Certification certification){
        return certificationRepository.save(certification);
    }

    @RequestMapping(value = "/{id}", method = POST)
    public Certification updateCertification(@PathVariable Long id, @RequestBody Certification certification){
        Certification existingCertification = certificationRepository.findById(id).orElse(null);
        if(existingCertification != null){
            existingCertification.setName(certification.getName());
            existingCertification.setDescription(certification.getDescription());
            return certificationRepository.save(existingCertification);
        }
        return null;
    }
}
