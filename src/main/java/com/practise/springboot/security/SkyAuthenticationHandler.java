package com.practise.springboot.security;

import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SkyAuthenticationHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response,
			org.springframework.security.core.AuthenticationException exception)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		

		response.addCookie(new Cookie("error", ""+exception.toString()));
		request.setAttribute("error", "true");		
		response.sendRedirect("");
	}
	// Some variables 


}