package com.kibrom.student_id_system.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;
import java.util.Date;



@Service
public class JwtService {



    private static final String SECRET_KEY =
            "student-id-system-secret-key-for-jwt-authentication-2026";


    private final long EXPIRATION_TIME =
            1000 * 60 * 60 * 24; // 24 hours




    private SecretKey getSigningKey(){


        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );

    }





    public String generateToken(
            String username
    ){


        return Jwts.builder()

                .subject(username)

                .issuedAt(
                        new Date()
                )

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + EXPIRATION_TIME
                        )
                )

                .signWith(
                        getSigningKey()
                )

                .compact();

    }






    public String extractUsername(
            String token
    ){


        return Jwts.parser()

                .verifyWith(
                        getSigningKey()
                )

                .build()

                .parseSignedClaims(token)

                .getPayload()

                .getSubject();

    }






    public boolean validateToken(
            String token
    ){


        try {


            Jwts.parser()

                    .verifyWith(
                            getSigningKey()
                    )

                    .build()

                    .parseSignedClaims(token);



            return true;


        } catch (JwtException e) {


            return false;

        }


    }


}