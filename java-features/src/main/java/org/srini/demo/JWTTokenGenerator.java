package org.srini.demo;

import java.util.Base64;
import java.util.Date;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
public class JWTTokenGenerator {


    public static void main(String[] args) throws Exception {
        // Programatically generate the secret key
        String secretKey = Base64.getEncoder().encodeToString(new byte[32]);
        System.out.println("Secret Key: " + secretKey);

        Date expirationDate = new Date(System.currentTimeMillis() + 3600000);  // Token is valid for 1 hour

        // Generate the token claims
        JwtBuilder builder = Jwts.builder()
                .setSubject("your_subject")
                .setExpiration(expirationDate)
                .setIssuedAt(new Date());

        // Generate the token
        String token = builder.signWith(SignatureAlgorithm.HS256, secretKey).compact();

        System.out.println(token);
    }
}
