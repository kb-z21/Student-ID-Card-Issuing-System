package com.kibrom.student_id_system.service;


import com.kibrom.student_id_system.entity.OTP;
import com.kibrom.student_id_system.repository.OTPRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;


@Service
public class OTPService {


    private final OTPRepository otpRepository;


    public OTPService(OTPRepository otpRepository) {
        this.otpRepository = otpRepository;
    }



    public OTP generateOTP(String createdBy) {


        String code = String.valueOf(
                100000 + new Random().nextInt(900000)
        );


        OTP otp = new OTP(
                code,
                createdBy,
                LocalDateTime.now().plusDays(1)
        );


        return otpRepository.save(otp);

    }



    public boolean verifyOTP(String code) {


        Optional<OTP> otp =
                otpRepository.findByCode(code);



        if(otp.isEmpty()) {
            return false;
        }


        OTP savedOtp = otp.get();



        if(savedOtp.isUsed()) {
            return false;
        }



        if(savedOtp.getExpireAt()
                .isBefore(LocalDateTime.now())) {

            return false;
        }



        savedOtp.setUsed(true);

        otpRepository.save(savedOtp);


        return true;

    }

}