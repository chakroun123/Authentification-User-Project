package org.management.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.management.entities.UserEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAutheticationFilter extends UsernamePasswordAuthenticationFilter {
   private AuthenticationManager authenticationManager;

    public JWTAutheticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserEntity userEntity= new ObjectMapper().readValue(request.getInputStream(),UserEntity.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntity.getUsername(),userEntity.getPassword()));

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        User user=(User)authResult.getPrincipal();

    }


}
