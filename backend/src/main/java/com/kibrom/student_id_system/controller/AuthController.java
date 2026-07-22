package com.kibrom.student_id_system.controller;



import com.kibrom.student_id_system.dto.LoginRequest;
import com.kibrom.student_id_system.dto.LoginResponse;
import com.kibrom.student_id_system.service.AuthService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api/auth")
public class AuthController {



    private final AuthService authService;




    public AuthController(
            AuthService authService
    ){

        this.authService = authService;

    }





    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(

            @RequestBody LoginRequest request

    ){


        return ResponseEntity.ok(
                authService.login(request)
        );


    }

}