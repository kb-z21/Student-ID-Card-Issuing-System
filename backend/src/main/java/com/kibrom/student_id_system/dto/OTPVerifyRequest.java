package com.kibrom.student_id_system.dto;


public class OTPVerifyRequest {


    private String otpCode;


    public OTPVerifyRequest() {
    }


    public String getOtpCode() {
        return otpCode;
    }


    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

}