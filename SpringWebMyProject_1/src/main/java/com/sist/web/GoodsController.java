package com.sist.web;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import com.sist.service.GoodsService;
import com.sist.vo.*;
import com.sist.dao.GoodsDAO;
import com.sist.service.*;
@Controller
@RequestMapping("goods/")
public class GoodsController {
	@Autowired
	private GoodsService service;
	
	@GetMapping("goods_list.do")
	private String goods_list(String page,Model model)
	{
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		List<GoodsVO> list=service.goodsListData(map);
		int totalpage=service.goodsTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		
		return "goods/goods_list.do";
	}
	
	@GetMapping("goods_detail_before.do")
	public String goods_detail_before(String no,HttpServletResponse response,RedirectAttributes ra)
	{
		Cookie cookie=new Cookie("spring_"+no, no);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		ra.addAttribute("no",no);
		return "redirect:goods_detail.do";
	}
	// 상세보기
	@GetMapping("goods_detail.do")
	public String goods_detail(int no,Model model)
	{
		GoodsVO vo=service.goodsDetailData(no);
		model.addAttribute("vo",vo);
		return "goods/goods_detail";
	}


}
