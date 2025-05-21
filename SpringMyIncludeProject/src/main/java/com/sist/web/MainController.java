package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.commons.CommonsPagination;
import com.sist.service.FoodService;
import com.sist.vo.*;
import java.util.*;
@Controller
public class MainController {
	@Autowired
	private FoodService service;
	
	@GetMapping("main/main.do")
	public String main_main(String page,Model model)
	{
		Map map=CommonsPagination.pageConfig(page, 12); // 공통 페이지 처리
		List<FoodVO> list=service.foodListData(map);
		int totalpage=service.foodTotalPage();
		int curpage=(int)map.get("curpage");
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		model.addAttribute("list",list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("curpage",curpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		
		model.addAttribute("main_jsp","../main/home.jsp");
		return "main/main";
	}
	
	@GetMapping("food/detail.do")
	public String food_detail(int fno,Model model)
	{
		FoodVO vo=service.foodDetailData(fno);

		model.addAttribute("vo",vo);
		model.addAttribute("main_jsp","../food/detail.jsp");
		return "main/main";
	}
	@GetMapping("food/find.do")
	public String food_find(String page,String fd,Model model)
	{
		Map map=CommonsPagination.pageConfig(page, 12);
		int curpage=(int)map.get("curpage");
		if(fd==null)
			fd="감자";
		map.put("fd", fd);
		List<FoodVO> list=service.foodFindData(map);
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		int totalpage=service.foodFindTotalPage(map);
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("fd",fd);
		model.addAttribute("main_jsp","../food/find.jsp");
		return "main/main";
	}
}
