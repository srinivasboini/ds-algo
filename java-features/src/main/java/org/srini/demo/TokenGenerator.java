/**
 * This class is responsible for generating JSON Web Tokens (JWTs).
 * It uses the Java JWT library (io.jsonwebtoken) to create tokens with a subject of "User"
 * and an expiration date of 1 day from the current date.
 *
 * For more information about JWTs and the Java JWT library, see:
 * - <a href="https://jwt.io/introduction/">Introduction to JSON Web Tokens (JWT)</a>
 * - <a href="https://github.com/jwtk/jjwt">Java JWT: JSON Web Token for Java and Android</a>
 */
package org.srini.demo;

import java.util.LinkedList;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

import static java.time.ZoneId.systemDefault;
import static java.util.Date.*;

public class TokenGenerator {

    /**
     * A secret key used for signing the JWTs.
     * This key is generated using the HS256 algorithm.
     */
    private static Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * Generates a JSON Web Token (JWT) with a subject of "User" and an expiration date of 1 day from the current date.
     *
     * @return a JWT as a compact, URL-safe string
     */
    public static String generateToken() {
        LocalDate now = LocalDate.now();
        LocalDate expiryDate = now.plusDays(1); // 1 day

        return Jwts.builder()
                .setSubject("User")
                .setIssuedAt(from(now.atStartOfDay(systemDefault()).toInstant()))
                .setExpiration(from(expiryDate.atStartOfDay(systemDefault()).toInstant()))
                .signWith(secretKey)
                .compact();
    }

    /**
     * The main method generates 10 JWTs and prints them to the console.
     *
     * @param args command line arguments (not used in this program)
     */
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>(); // Initialize with a type parameter for generics

        // Generate and add tokens to the linked list
        for (int i = 0; i < 10; i++) {
            linkedList.add(generateToken());
        }

        // Print the generated tokens
        for (String token : linkedList) {
            System.out.println(token);
        }
    }
}
