package com.interview.task.sfl.restaurant.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyCustomFilter extends UsernamePasswordAuthenticationFilter {

  @Autowired
  private MyUserDetails myUserDetails;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {

        String authToken = retrieveToken((HttpServletRequest) req);

        if (authToken != null) {
            UserDetails userDetails = myUserDetails.loadUserByUUID(authToken);
            if (userDetails != null) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        try {
            filterChain.doFilter(req, res);
        } finally {
            SecurityContextHolder.clearContext();
        }

  }

  private String retrieveToken(HttpServletRequest request){
    String token = request.getHeader("Authorization");

    if (token == null){
      return null;
    }

    return token.substring(7);
  }
}
