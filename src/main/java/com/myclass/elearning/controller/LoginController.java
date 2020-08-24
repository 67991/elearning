package com.myclass.elearning.controller;

import com.myclass.elearning.dto.UserLogin;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("api/auth")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("")
    public ResponseEntity<String> login(@RequestBody UserLogin userLogin){
        try{
            System.out.println(userLogin.getEmail());
            System.out.println(userLogin.getPassword());
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            String token = generateToken(authenticate);

            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e){

            e.printStackTrace();
            return new ResponseEntity(HttpStatus.UNAUTHORIZED) ;
        }
    }

    private String generateToken (Authentication authentication){
        final String JWT_SECRET = "cybersoft";
        final long JWT_EXPIRATION = 24 * 60 * 60 * 1000L;
        Date now = new Date();
        Date expiryDate = new Date(now.getTime()+ JWT_EXPIRATION);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        //Tạo chuổi json web token từ id của user.
        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
        return token;
    }

}
