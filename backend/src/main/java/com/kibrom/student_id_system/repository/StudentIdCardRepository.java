package com.kibrom.student_id_system.repository;


import com.kibrom.student_id_system.entity.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentIdCardRepository
        extends JpaRepository<StudentIdCard, Long> {


}