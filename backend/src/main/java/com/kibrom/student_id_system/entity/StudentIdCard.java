package com.kibrom.student_id_system.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "student_id_cards")
public class StudentIdCard {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Generated ID
    // Example: STU-R-000001
    @Column(nullable = false, unique = true)
    private String cardNumber;



    @Column(nullable = false)
    private LocalDate issueDate;



    @Column(nullable = false)
    private LocalDate expireDate;



    // Location of generated PDF
    private String pdfPath;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardStatus status;



    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;



    public StudentIdCard() {
    }



    public StudentIdCard(
            String cardNumber,
            LocalDate issueDate,
            LocalDate expireDate,
            String pdfPath,
            CardStatus status,
            Student student
    ) {

        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
        this.pdfPath = pdfPath;
        this.status = status;
        this.student = student;

    }



    public Long getId() {
        return id;
    }


    public String getCardNumber() {
        return cardNumber;
    }


    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    public LocalDate getIssueDate() {
        return issueDate;
    }


    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }


    public LocalDate getExpireDate() {
        return expireDate;
    }


    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }


    public String getPdfPath() {
        return pdfPath;
    }


    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }


    public CardStatus getStatus() {
        return status;
    }


    public void setStatus(CardStatus status) {
        this.status = status;
    }


    public Student getStudent() {
        return student;
    }


    public void setStudent(Student student) {
        this.student = student;
    }
}