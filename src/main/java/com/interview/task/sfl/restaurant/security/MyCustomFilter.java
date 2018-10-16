package com.interview.task.sfl.restaurant.security;

import com.interview.task.sfl.restaurant.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class MyCustomFilter extends GenericFilterBean {

  @Autowired
  MyUserDetails myUserDetails;

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
      throws IOException, ServletException {

    String UUID = resolveUUID((HttpServletRequest) req);
    try {
      if (UUID != null && isUUID(UUID)) {
        UserDetails userDetails = myUserDetails.loadUserByUUID(UUID);
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    } catch (CustomException ex) {
      HttpServletResponse response = (HttpServletResponse) res;
      response.sendError(ex.getHttpStatus().value(), ex.getMessage());
      return;
    }

    filterChain.doFilter(req, res);
  }

  private String resolveUUID(HttpServletRequest req) {
    String bearerToken = req.getHeader("Authorization");
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7, bearerToken.length());
    }
    return null;
  }

  private boolean isUUID(String string) {
    try {
      UUID.fromString(string);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }
}
