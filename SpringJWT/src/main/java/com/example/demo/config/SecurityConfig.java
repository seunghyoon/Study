package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import com.example.demo.jwt.JwtAccessDeniedHandler;
import com.example.demo.jwt.JwtAuthenticationEntryPoint;
import com.example.demo.jwt.TokenProvider;




@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
	
	
    private final CorsFilter corsFilter;
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
	
	public SecurityConfig(CorsFilter corsFilter,
			TokenProvider tokenProvider,
			JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
			JwtAccessDeniedHandler jwtAccessDeniedHandler) {
		
		 this.tokenProvider = tokenProvider;
	     this.corsFilter = corsFilter;
	     this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
	     this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
	
	}
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        		
        	.csrf().disable().addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class) // token을 사용하는 방식이기 때문에 csrf를 disable합니다.
            .headers().frameOptions().sameOrigin()
            .and().authorizeHttpRequests((authz) -> authz
            	  .requestMatchers("/api/hello","/h2-console/*").permitAll()
            	  .requestMatchers(PathRequest.toH2Console()).permitAll()
                  .anyRequest().authenticated()
            
            );
        return http.build();
    }
    
    
}
