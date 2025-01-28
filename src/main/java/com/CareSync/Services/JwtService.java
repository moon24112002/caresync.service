package com.CareSync.Services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService{


    @Value("${security.jwt.secret-key}")
    private String secret_key;

    @Value("${security.jwt.expiration-time}")
    private String jwt_expiration;



}
