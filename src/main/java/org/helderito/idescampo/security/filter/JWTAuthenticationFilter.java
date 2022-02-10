package org.helderito.idescampo.security.filter;
/*
import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.helderito.idescampo.domain.model.Usuario;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static org.helderito.idescampo.security.filter.Constants.EXPIRATION_TIME;
import static org.helderito.idescampo.security.filter.Constants.SECRET;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
*/
	
	/*
	 * Quem é voçe!
	 */
/*
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws  AuthenticationException {
		try {
			
			Usuario user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
		
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getNomeUsuario(), user.getSenha()));
		
			}catch(IOException ex) {
				throw new RuntimeException(ex);
		}		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
	
		ZonedDateTime expTimeUTC = ZonedDateTime.now(ZoneOffset.UTC).plus(EXPIRATION_TIME,ChronoUnit.MILLIS);	
		
		String token = Jwts.builder()
				.setSubject(((Usuario)authResult.getPrincipal()).getNomeUsuario())
				.setExpiration(Date.from(expTimeUTC.toInstant()))
				.signWith(SignatureAlgorithm.HS256, SECRET)
				.compact();
	}
}
*/
	

