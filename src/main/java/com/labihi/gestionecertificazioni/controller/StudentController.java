package com.labihi.gestionecertificazioni.controller;

import com.labihi.gestionecertificazioni.entity.Exam;
import com.labihi.gestionecertificazioni.entity.Student;
import com.labihi.gestionecertificazioni.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    @RequestMapping("")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentRepository.findById(id).orElse(null);
    }

    @RequestMapping("/{id}/exams")
    public List<Exam> getStudentExams(@PathVariable Long id){
        return Objects.requireNonNull(studentRepository.findById(id).orElse(null)).getExams();
    }

    @RequestMapping(value = "",method = POST)
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @RequestMapping(value = "/{id}",method = POST)
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if(existingStudent != null){
            existingStudent.setName(student.getName());
            existingStudent.setSurname(student.getSurname());
            existingStudent.setExams(student.getExams());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

}
