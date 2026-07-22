package com.kibrom.student_id_system.controller;


import com.kibrom.student_id_system.dto.StudentRegistrationRequest;
import com.kibrom.student_id_system.dto.StudentResponse;
import com.kibrom.student_id_system.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/students")
public class StudentController {



    private final StudentService studentService;



    public StudentController(StudentService studentService) {

        this.studentService = studentService;

    }



    @PostMapping("/register")
    public ResponseEntity<StudentResponse> register(
            @RequestBody StudentRegistrationRequest request
    ) {


        StudentResponse response =
                studentService.registerStudent(request);


        return ResponseEntity.ok(response);

    }

}