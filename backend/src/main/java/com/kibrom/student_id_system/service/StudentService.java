package com.kibrom.student_id_system.service;


import com.kibrom.student_id_system.dto.StudentRegistrationRequest;
import com.kibrom.student_id_system.dto.StudentResponse;
import com.kibrom.student_id_system.entity.CardStatus;
import com.kibrom.student_id_system.entity.Student;
import com.kibrom.student_id_system.entity.StudentIdCard;
import com.kibrom.student_id_system.repository.StudentIdCardRepository;
import com.kibrom.student_id_system.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;



@Service
public class StudentService {


    private final StudentRepository studentRepository;

    private final StudentIdCardRepository studentIdCardRepository;

    private final UniversityEmailGeneratorService emailGenerator;

    private final StudentIdGeneratorService idGenerator;



    public StudentService(
            StudentRepository studentRepository,
            StudentIdCardRepository studentIdCardRepository,
            UniversityEmailGeneratorService emailGenerator,
            StudentIdGeneratorService idGenerator
    ) {

        this.studentRepository = studentRepository;
        this.studentIdCardRepository = studentIdCardRepository;
        this.emailGenerator = emailGenerator;
        this.idGenerator = idGenerator;

    }




    public StudentResponse registerStudent(
            StudentRegistrationRequest request
    ) {


        // 1. Create student

        Student student = new Student();


        student.setFirstName(request.getFirstName());

        student.setMiddleName(request.getMiddleName());

        student.setLastName(request.getLastName());

        student.setDepartment(request.getDepartment());

        student.setProgram(request.getProgram());

        student.setYearLevel(request.getYearLevel());

        student.setStartYear(request.getStartYear());

        student.setPhotoPath(request.getPhotoPath());



        // 2. Generate university email

        String email =
                emailGenerator.generateEmail(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getProgram(),
                        request.getStartYear()
                );


        student.setUniversityEmail(email);



        studentRepository.save(student);



        // 3. Generate student ID

        String studentId =
                idGenerator.generateStudentId(
                        request.getProgram()
                );



        // 4. Create ID card

        LocalDate issueDate =
                LocalDate.now();


        LocalDate expireDate =
                issueDate.plusYears(4);



        StudentIdCard card =
                new StudentIdCard();


        card.setCardNumber(studentId);

        card.setIssueDate(issueDate);

        card.setExpireDate(expireDate);

        card.setStatus(CardStatus.ACTIVE);

        card.setStudent(student);



        studentIdCardRepository.save(card);



        return new StudentResponse(
                "Student registered successfully",
                studentId,
                email
        );

    }

}