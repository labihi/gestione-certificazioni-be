package com.labihi.gestionecertificazioni.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "exam")
@Data
@SequenceGenerator(name = "id_exam", sequenceName = "id_exam_seq", allocationSize = 1)
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_exam_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "certification_id", nullable = false)
    private Certification certification;

    @ManyToMany(mappedBy = "exams")
    private List<Student> students;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;

}