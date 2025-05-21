package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@RestController
public class RecipeRestController {
	@Autowired
	private RecipeDAO dao;
	
	@GetMapping(value="recipe/list_vue.do",produces="text/plain;charset=UTF-8")
	public String list_vue() throws Exception
	{
		List<RecipeVO> list=dao.recipeListData();
		// javascript가 인식하도록 => JSON
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
}
