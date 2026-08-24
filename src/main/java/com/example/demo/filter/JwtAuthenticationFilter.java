package com.example.demo.filter;


import com.example.demo.util.JwtUtil;


import jakarta.servlet.*;

import jakarta.servlet.http.HttpServletRequest;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.SecurityContextHolder;


import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;



@Component
public class JwtAuthenticationFilter 
        extends OncePerRequestFilter {



    private final JwtUtil jwtUtil;



    public JwtAuthenticationFilter(
            JwtUtil jwtUtil
    ){

        this.jwtUtil=jwtUtil;

    }




    @Override

    protected void doFilterInternal(

            HttpServletRequest request,

            jakarta.servlet.http.HttpServletResponse response,

            FilterChain chain

    ) throws IOException, ServletException {



        String header =
                request.getHeader("Authorization");



        if(header!=null &&
                header.startsWith("Bearer ")){

            String token=
                    header.substring(7);



            String username=
                    jwtUtil.getUsername(token);



            UsernamePasswordAuthenticationToken auth=

                    new UsernamePasswordAuthenticationToken(

                            username,

                            null,

                            null

                    );



            SecurityContextHolder

                    .getContext()

                    .setAuthentication(auth);


        }



        chain.doFilter(request,response);


    }

}
