package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataBoardAOP {
	@Around("execution(* com.sist.web.*Controller.*(..))")// (..) 모든 매개변수를 받음 () 매개변수 안 받음
	// => Controller가 가진 모든 클래스, 메소드를 받음
	public Object around(ProceedingJoinPoint jp) throws Throwable 
	// exception 쓰면 에러 => proceed가 throwable 받음 => exception의 상위 클래스
	{
		Object obj=null;
		System.out.println("수행 메소드:"+jp.getSignature().getName());
		// 사용자 요청 메소드 이름 알아내기
		long start=System.currentTimeMillis();
		obj=jp.proceed();// 실제 호출된 메소드 알아내기
		long end=System.currentTimeMillis();
		// 총 걸린 시간 알아보는 로그 파일
		System.out.println("수행 시간:"+(end-start));
		return obj;
	}
}
