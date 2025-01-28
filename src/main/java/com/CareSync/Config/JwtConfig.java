package com.CareSync.Config;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtConfig {

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;
    private static final int TOKEN_VALIDITY = 3600 * 1000; // 1 hour
    public String generateJwtToken(String email){
      return Jwts.builder().setSubject(email).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+TOKEN_VALIDITY)).signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }

}
