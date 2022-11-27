package pe.edu.upao.sistemas.todoapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.jackson.io.JacksonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable
{
    private static final long   serialVersionUID    = 8544329907338151549L;
//  public static final long    JWT_TOKEN_VALIDITY  = 5 * 60 * 60 * 1000; // 5 Hours
    public static final long    JWT_TOKEN_VALIDITY  = 60 * 60 * 1000 * 24; // 5 Minutes
    private String secret = "614E645267556B58703273357638782F413F4428472B4B6250655368566D597133743677397A244226452948404D635166546A576E5A7234753778214125442A";

    @Autowired ObjectMapper objectMapper;

    /*
     * 1. data = desencripta(token)
     * 2. usuario = data['subject/usuario']
     * 3. return usuario
     * */
    public String getUsernameFromToken(String token)
    {
        return getClaimFromToken(token, Claims::getSubject);


    }

    /*
    * 1. data = desencripta(token)
    * 2. expiracion = data['expiración']
    * 3. return expiración
    * */

    public Date getExpirationDateFromToken(String token)
    {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token)
    {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token)
    {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(String username)
    {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, username);
    }
    private String doGenerateToken(Map<String, Object> claims, String subject)
    {
        return "Bearer "+ Jwts.builder()
                .serializeToJsonWith(new JacksonSerializer(objectMapper))
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Boolean validateToken(String token, String usernameFromToken)
    {
        final String username = getUsernameFromToken(token);
        return (username.equals(usernameFromToken) && !isTokenExpired(token));
    }
}