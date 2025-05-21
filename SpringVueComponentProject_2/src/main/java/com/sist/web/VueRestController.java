package com.sist.web;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.sist.dao.*;
@RestController
public class VueRestController {
	@Autowired
	private VueDAO dao;
	
	@GetMapping("food/list_vue.do")
	public Map food_list_vue(int page)
	{
		Map map=new HashMap();
		map.put("start", (page*12)-11);
		map.put("end", page*12);
		List<FoodVO> list=dao.foodListData(map);
		int totalpage=dao.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		map=new HashMap();
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("curpage", page);
		map.put("list", list);
		map.put("endPage", endPage);
		
		return map;
		
	}
}
