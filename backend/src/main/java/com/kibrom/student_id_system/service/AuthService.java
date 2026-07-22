package com.kibrom.student_id_system.service;


import com.kibrom.student_id_system.dto.LoginRequest;
import com.kibrom.student_id_system.dto.LoginResponse;
import com.kibrom.student_id_system.security.JwtService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.stereotype.Service;



@Service
public class AuthService {



    private final AuthenticationManager authenticationManager;


    private final JwtService jwtService;




    public AuthService(
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ){

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;

    }






    public LoginResponse login(
            LoginRequest request
    ){



        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getUsername(),

                        request.getPassword()

                )

        );



        String token =
                jwtService.generateToken(
                        request.getUsername()
                );



        return new LoginResponse(

                token,

                request.getUsername()

        );


    }


}