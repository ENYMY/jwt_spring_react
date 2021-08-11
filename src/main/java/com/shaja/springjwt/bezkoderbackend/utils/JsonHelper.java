package com.shaja.springjwt.bezkoderbackend.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JsonHelper {
    @Value("${JWT_Secretkey}")
    private String secretKey;

//    GENEERATE NEW TOKEN
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("SHAJANASIR")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
    }

//    Reading claims from jwt
    public Claims readClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

//    Read Expiry Date
    public Date readExpiryDate(String token) {
        Date expirationDate = readClaims(token).getExpiration();
        return  expirationDate;
    }
// Validate Token
    public boolean isTokenValid(String token,String username){
//        if token is not expired and tokenusername and database username is same
            return !isTokenExpired(token) && username.equals(readUsername(token));
    }

//    readSubject the username
    public String readUsername(String token) {
        return readClaims(token).getSubject();
    }

//check isTokenExpired
    public boolean isTokenExpired(String token) {
        Date todayDate  = new Date(System.currentTimeMillis());
        Date expirationDate= readExpiryDate(token);
        return expirationDate.before(todayDate);
    }
}
