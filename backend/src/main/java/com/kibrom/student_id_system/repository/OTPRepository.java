package com.kibrom.student_id_system.repository;


import com.kibrom.student_id_system.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OTPRepository extends JpaRepository<OTP, Long> {


    Optional<OTP> findByCode(String code);


}