package com.kibrom.student_id_system.dto;


public class StudentResponse {


    private String message;

    private String studentId;

    private String universityEmail;



    public StudentResponse() {
    }



    public StudentResponse(
            String message,
            String studentId,
            String universityEmail
    ) {

        this.message = message;
        this.studentId = studentId;
        this.universityEmail = universityEmail;

    }



    public String getMessage() {
        return message;
    }


    public String getStudentId() {
        return studentId;
    }


    public String getUniversityEmail() {
        return universityEmail;
    }

}