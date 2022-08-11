package com.labihi.gestionecertificazioni.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "certification")
@Data
@SequenceGenerator(name = "id_cert", sequenceName = "id_cert_seq", allocationSize = 1)

public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_cert_seq")
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column (name = "description", nullable = false)
    private String description;


}