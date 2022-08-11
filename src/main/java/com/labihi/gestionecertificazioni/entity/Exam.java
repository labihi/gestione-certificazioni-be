package com.labihi.gestionecertificazioni.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exam")
@Data
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "certification_id")
    private Certification certification;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Date data;

}