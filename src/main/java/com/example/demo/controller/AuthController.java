package com.example.demo.controller;


import com.example.demo.model.LoginRequest;

import com.example.demo.util.JwtUtil;


import org.springframework.web.bind.annotation.*;



@RestController
public class AuthController {



    private final JwtUtil jwtUtil;



    public AuthController(JwtUtil jwtUtil){

        this.jwtUtil=jwtUtil;

    }




    @PostMapping("/login")

    public String login(
            @RequestBody LoginRequest request
    ){


        if(
                "test".equals(request.getUsername())
                &&
                "123456".equals(request.getPassword())
        ){

            return jwtUtil.generateToken(
                    request.getUsername()
            );

        }


        return "Login Failed";

    }


}
