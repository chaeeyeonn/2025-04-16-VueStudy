package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/*
 *   기능이 있는 클래스 => 스프링이 관리
 *   					객체 생성 ~ 소멸
 *   					-------
 *   					1. 메모리 할당
 *   					2. 멤버 변수 초기화
 *   						DI => setXxx(), 생성자
 *   						--값 주입
 *   					3. 필요시마다 객체를 찾아서 사용 가능
 *   						DL => @Autowired
 *   					-------------------------------
 *   					=> 클래스 관리자(Container)
 *   					   복잡한 클래스(관계도가 많은 경우)
 *   						=> 연관관계가 없는 독립적인 클래스 제작
 *   					=> MVC는 스프링의 라이브러리
 *   	
 *   	- 객체 생성 요청
 *   	  ------------
 *   	  각 클래스마다 메모리 할당
 *   	 <bean id="" class="">
 *   	 => 모든 클래스를 관리하는 것이 아니다
 *   		인터페이스, 사용자 정의 데이터형, 임시 클래스, ...(X)
 *   		=> WEB => 선택적 메모리 할당
 *      	   1. DAO: @Repository
 *       	   2. Service: @Service
 *             3. Model: @Component
 *             4. Manager: @Component
 *             5. AOP: @Component
 *            => + @RestController / @ControllerAdvice
 *            => 나머지는 개발자 관리
 *            => DI => 객체 생명주기 관리 / 클래스 간의 연관관계 설정
 *            
 *      - AOP : 공통 모듈(여러 위치에 호출)
 *      		=> 보안, 로깅, 트랜잭션,...
 *      - 중복 제거: OOP(객체지향프로그램) => 메소드, 메소드 많은 경우 클래스
 *      		   AOP => 자동 호출 가능(OOP 보완)
 *      	자동호출을 하려면
 *          : 어떤 메소드에서 호출할 것인가 => PointCut
 *          : 메소드 영역 안에 어떤 위치에 호출할 것인가 => JoinPoint
 *          => Advice
 *          
 */
@Aspect
@Component
public class ControllerAspect {
	// 로깅 파일 만들기
	@Around("execution(* com.sist.web.*Controller.*(..))")
	public Object around(ProceedingJoinPoint jp)
	throws Throwable
	{
		Object obj=null;
		long start=System.currentTimeMillis();
		System.out.println("호출 메소드:"+jp.getSignature().getName());
		obj=jp.proceed();// 메소드 호출
		long end=System.currentTimeMillis();// 호출 시간 확인
		System.out.println("수행시간:"+(end-start));
		return obj;
	}
	@AfterReturning(value = "execution(* com.sist.web.*Controller.*(..))",returning="obj")
	public void afterReturning(Object obj)
	{
		if(obj!=null)
		{
			String path=(String)obj;
			System.out.println("호출된 JSP:"+path);
		}
	}
	// ControllerAdvice: Controller 예외처리를 공통으로 처리
}
