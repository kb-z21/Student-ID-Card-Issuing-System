package com.kibrom.student_id_system.controller;


import com.kibrom.student_id_system.entity.OTP;
import com.kibrom.student_id_system.service.OTPService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/otp")
public class OTPController {


    private final OTPService otpService;


    public OTPController(OTPService otpService) {
        this.otpService = otpService;
    }



    @PostMapping("/generate")
    public ResponseEntity<OTP> generateOTP(
            @RequestParam String createdBy
    ) {

        OTP otp =
                otpService.generateOTP(createdBy);


        return ResponseEntity.ok(otp);

    }

}