package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.checkerframework.framework.qual.AnnotatedFor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.service.*;
// JSP로 요청 결과값 전송
@Controller
@RequestMapping("food/")
public class FoodRecipeController {
	@Autowired
	private FoodRecipeService service;
	
	// 목록 => 405(Post,Get 오류)
	/*
	 *  404: file 없음
	 *  405: get, post
	 *  500: db 오류
	 *  400: bad request 매개변수 오류
	 */
	@GetMapping("food_list.do") // target: method => 메소드 위에만 올려야 한다
	public String food_list(String page,Model model)
	{
		// 처음 null값 넘어가는 게 있다면 매개변수는 String, 아니면 int
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		Map map=new HashedMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		List<FoodVO> list=service.foodListData(map);
		int totalpage=service.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		//food_list 전송
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		return "food/food_list";
	}
	// 쿠키
	@GetMapping("food_detail_before.do")
	public String food_detail_before(String fno,HttpServletResponse response,RedirectAttributes ra)
	{
		// fno, response 2개의 매개변수
		// => request.setAttribute => model
		Cookie cookie=new Cookie("spring_"+fno, fno);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		ra.addAttribute("fno",fno);//sendRedirect에서만 사용, ?를 대신함
		return "redirect:food_detail.do";
	}
	// 상세보기
	@GetMapping("food_detail.do")
	public String food_detail(int fno,Model model)
	{
		FoodVO vo=service.foodDetailData(fno);
		model.addAttribute("vo",vo);
		return "food/food_detail";
	}
	
}
