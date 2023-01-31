package com.example.demo.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.example.demo.jwt.TokenProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class JwtFilter extends GenericFilterBean{
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	@Autowired
	private TokenProvider tokenProvider; 
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String jwt = resolveToken(httpServletRequest);
		System.out.println("jwt ========"+ jwt);
		String requestURI = httpServletRequest.getRequestURI();
		System.out.println("requestURI ========"+ requestURI);
		
		
	}
	
	private String resolveToken(HttpServletRequest request) {
		String beareToken = request.getHeader(AUTHORIZATION_HEADER);
		if(StringUtils.hasText(beareToken) 
				&& beareToken.startsWith("Bearer ")) {
			return beareToken.substring(7);
		}
		return null;
	}
}
