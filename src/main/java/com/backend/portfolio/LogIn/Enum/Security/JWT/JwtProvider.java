/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.portfolio.LogIn.Enum.Security.JWT;

import com.backend.portfolio.LogIn.Enum.Entity.UserP;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import static io.jsonwebtoken.SignatureAlgorithm.HS512;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
/**
 *
 * @author Mateo De Mari
 */
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    public String generateToken(Authentication authentication) {
        UserP userP = (UserP) authentication.getPrincipal();
        return Jwts.builder().setSubject(userP.getUsername ()).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+expiration*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
    }
    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateToken(String token) {
        try {Jwts.parser().setSigningKey(secret).parseClaimsJws(token); return true; }
        
        catch (MalformedJwtException e) {logger.error("El token no se ha formado con exito");}
        catch (UnsupportedJwtException e)  {logger.error("El token no es soportado");}
        catch (ExpiredJwtException e) {logger.error("El token ya ha expirado"); }
        catch (IllegalArgumentException e)  {logger.error("El token esta vacio");}
        catch (SignatureException e) {logger.error("El token no s");}
                return false;
                }
    }
