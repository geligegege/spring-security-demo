package com.example.demo.util;


import io.jsonwebtoken.*;

import org.springframework.stereotype.Component;


import java.util.Date;



@Component
public class JwtUtil {


    private final String secret="security-demo-secret-key";



    public String generateToken(String username){


        return Jwts.builder()

                .setSubject(username)

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                +3600000
                        )
                )

                .signWith(
                        SignatureAlgorithm.HS256,
                        secret
                )

                .compact();

    }



    public String getUsername(String token){


        return Jwts.parser()

                .setSigningKey(secret)

                .parseClaimsJws(token)

                .getBody()

                .getSubject();

    }

}
