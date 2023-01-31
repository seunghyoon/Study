package com.example.demo.jwt;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.security.SecurityException;

@Component
public class TokenProvider implements InitializingBean{
	private static final String AUTHORITIES_KEY = "auth";
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.token-validity-in-milli-seconds}")
	private Long tokenValidityInMilliseconds;
	
	private Key key;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("secret ---------" + secret);
		byte[] keyBytes = Decoders.BASE64.decode(secret);
		System.out.println("keyBytes ---------" + keyBytes);
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}
	/*
	 * jwt Token 생성
	 * 
	 */
	public String createToken(Authentication authentication) {
		String authorities = authentication.getAuthorities().stream()
				.map(GrantedAuthority :: getAuthority)
				.collect(Collectors.joining(","));
		System.out.println("authorities ---------" + authorities);
		
		
		String createTokenData = Jwts.builder()
				.setSubject(authentication.getName())
				.claim(AUTHORITIES_KEY, authorities)
				.signWith(key, SignatureAlgorithm.HS512)
				.setExpiration(java.sql.Timestamp.valueOf(LocalDateTime.now().plus(tokenValidityInMilliseconds, ChronoUnit.MILLIS)))
				.compact();
		return createTokenData;
	}
	/*
	 * jwt Token 권한정보 return 
	 */
	public Authentication getAuthentication(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(key)
				.build().parseClaimsJws(token)
				.getBody();
		Collection<? extends GrantedAuthority> authorities = 
				Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
					.map(SimpleGrantedAuthority :: new)
					.collect(Collectors.toList());
		User principal = new User(claims.getSubject(), "", authorities);
		new UsernamePasswordAuthenticationToken(principal, token, authorities);
		return null;
	}
	
	/*
	 * jwt Token validateToken
	 */
	public Boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			System.out.println("validateToken 정상");
			return true;
		}catch(SecurityException | MalformedJwtException e) {
			System.out.println("잘못된 JWT 서명입니다.");
			e.printStackTrace();
		}catch(ExpiredJwtException e) {
			System.out.println("만료된 JWT 토큰입니다.");
			e.printStackTrace();
		}catch(UnsupportedJwtException e) {
			System.out.println("지원되지 않는 JWT 토큰입니다.");
			e.printStackTrace();
		}catch(IllegalArgumentException e) {
			System.out.println("JWT 토큰이 잘못되었습니다.");
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(new Date());
		long now = new Date().getTime();
		System.out.println(now);
		
		Date validity = new Date(now + 864000000);
		System.out.println(validity);
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.now().plus(864000000, ChronoUnit.MILLIS));
	}
	
}
