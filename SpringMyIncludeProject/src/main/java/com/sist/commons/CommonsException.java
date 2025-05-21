package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex)
	{
		System.out.println("======오류오류오류======");
		ex.printStackTrace();
	}
}
