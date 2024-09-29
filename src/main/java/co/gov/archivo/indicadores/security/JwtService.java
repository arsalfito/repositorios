package co.gov.archivo.indicadores.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import co.gov.archivo.indicadores.dtos.RoleDto;
import co.gov.archivo.indicadores.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

  static String SECRET_KEY = "dgjorufhrsnjdu438fkdj38fdmcv7dm3ckvhrsnjjuwelueivhe848fhedldh5ndk";

  //@Autowired
  //private UsuarioService usuarioService;
  
  public String getToken(Usuario user, Long idAplicacionAtenea) {
    return createToken(user, idAplicacionAtenea);
  }
  
  public String createToken(Usuario user, Long idAplicacionAtenea) {
	  RoleDto role = null;
    Map<String, Object> claims = new HashMap<>();
    
    claims.put("id", user.getId());
    claims.put("name", user.getPersona().getNombre());
    claims.put("roles", role);
    claims.put("idPerson", user.getPersona().getId());

    Date now = new Date();
    Date exp = new Date(now.getTime() + 3600000);

    return Jwts.builder()
        .claims(claims)
        .subject(user.getUsername())
        .issuedAt(now)
        .expiration(exp)
        .signWith(getKey())
        .compact();
  }
  
  private SecretKey getKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
  public String getUsernameFromToken(String token) {
    return getClaim(token, Claims::getSubject);
  }
  public boolean isTokenValid(String token, Usuario user) {
    String username = getUsernameFromToken(token);
    return (username.equals(user.getUsername()) && !isTokenExpired(token));
  }  
  private Claims getAllClaims(String token) {
    return Jwts
        .parser()
        .verifyWith((SecretKey) getKey())
        .build()
        .parseSignedClaims(token).getPayload();
  }
  public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
    Claims claims = getAllClaims(token);
    return claimsResolver.apply(claims);
  }
  private Date getExpiration(String token) {
    return getClaim(token, Claims::getExpiration);
  }
  private boolean isTokenExpired(String token) {
    return getExpiration(token).before(new Date());
  }
 
}
