package com.sist.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 자동 로그인
/*
 *  1. Controller 역할, AOP 역할
 *  2. Task 역할 => 스케쥴러
 *  3. Interceptor => 중간 필요한 부분에 기능 추가
 *  4. DAO / Service
 *  ---------------------------------------
 *  include => tiles 변경
 *  보안 / betch / 통계
 *  	         -----파이썬(Pandas,Numpy)
 *  
 *  main.do ==== DispatcherServlet ==== HandlerMapping
 *                                      => Mapping 전 중간 처리: preHandle
 *  									| Model을 찾아서 메소드 호출
 *  									  (@GetMapping, @PostMapping) => @RequestMapping
 *                                      | request.setAttribute()
 *                                        return ""
 *                                      => postHandle
 *                                      | ViewResolver
 */
public class RecipeInterceptor extends HandlerInterceptorAdapter{
	// 자동로그인 , ID 저장 remember-me
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
}
