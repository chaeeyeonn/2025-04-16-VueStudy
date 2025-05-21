package com.sist.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.Setter;

public class LoginFailureHandler implements AuthenticationFailureHandler{
	@Setter
	private String defaultFailureUrl;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
			String errorMsg="";
			try
			{
				if(exception instanceof BadCredentialsException)
				{
					errorMsg="���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�";
				}
				else if(exception instanceof DisabledException)
				{
					errorMsg="�޸�����Դϴ�";
				}
			}catch(Exception ex) {}
			request.setAttribute("message", errorMsg);
			request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	}

}
