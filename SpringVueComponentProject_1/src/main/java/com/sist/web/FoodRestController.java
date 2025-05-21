package com.sist.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.vo.*;
import com.sist.dao.*;
import java.util.*;
@RestController
public class FoodRestController {
	 @Autowired
	 private FoodDAO dao;
   
	/*
	 * @PostMapping("food/vue_check2_vue.do") public Map vue_check(String ss,String
	 * f) { Map map = new HashMap(); map.put("f", f); map.put("ss", ss); return map;
	 * }
	 */
	
	@PostMapping("food/list_vue.do")
	public List<FoodVO> food_list(int page,String[] ss,String fd)
	{
		Map map=new HashMap();
		map.put("fdArr", ss);
		map.put("ss", fd);
		map.put("start", (page*12)-11);
		map.put("end", page*12);
		
		List<FoodVO> list=dao.foodFindData(map);
		return list;
	}
}
