package com.kibrom.student_id_system.dto;


import com.kibrom.student_id_system.entity.ProgramType;


public class StudentRegistrationRequest {


    private String firstName;

    private String middleName;

    private String lastName;

    private String department;

    private ProgramType program;

    private Integer yearLevel;

    private Integer startYear;

    private String photoPath;



    public StudentRegistrationRequest() {
    }



    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddleName() {
        return middleName;
    }


    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public ProgramType getProgram() {
        return program;
    }


    public void setProgram(ProgramType program) {
        this.program = program;
    }


    public Integer getYearLevel() {
        return yearLevel;
    }


    public void setYearLevel(Integer yearLevel) {
        this.yearLevel = yearLevel;
    }


    public Integer getStartYear() {
        return startYear;
    }


    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }


    public String getPhotoPath() {
        return photoPath;
    }


    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

}