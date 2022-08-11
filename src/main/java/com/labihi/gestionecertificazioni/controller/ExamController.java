package com.labihi.gestionecertificazioni.controller;

import com.labihi.gestionecertificazioni.entity.Exam;
import com.labihi.gestionecertificazioni.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam")
public class ExamController {
    private final ExamRepository examRepository;

    @GetMapping("")
    public List<Exam> getAllExam(){
        return examRepository.findAll();
    }

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id){
        return examRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esame non valido"));
    }

    //Search by location
    @GetMapping("/search")
    public List<Exam> getExamByAula(@RequestParam(required = true) String location){
        return examRepository.findByLocation(location);
    }

    @PostMapping("")
    public Exam createExam(@RequestBody Exam exam){
        return examRepository.save(exam);
    }

    @PostMapping("/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam exam){
        Exam existingExam = examRepository.findById(id).orElse(null);
        if(existingExam != null){
            existingExam.setLocation(exam.getLocation());
            existingExam.setData(exam.getData());
            return examRepository.save(existingExam);
        }
        return null;
    }
}
