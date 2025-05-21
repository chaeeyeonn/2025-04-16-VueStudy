package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;

import java.util.*;
@RestController
public class RecipeRestController {
	@Autowired
	private RecipeDAO dao;
	
	@GetMapping(value="recipe/list_vue.do",produces="text/plain;charset=UTF-8")
	public String list_vue(int page) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		List<RecipeVO> list=dao.recipeListData(start, end);
		int totalpage=dao.recipeTotalPage();
		
		Map map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		
		//JSON 변환 => 자바스크립트에서 인식
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	@GetMapping(value="recipe/find_vue.do",produces = "text/plain;charset=UTF-8")
	   public String find_vue(int page,String fd) throws Exception
	   {
		   int rowSize=12;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=rowSize*page;
		   Map map=new HashMap();
		   map.put("start", start);
		   map.put("end", end);
		   map.put("fd", fd);
		   List<RecipeVO> list=dao.recipeFindListData(map);
		   int totalpage=dao.recipeFindTotalPage(fd);
		   
		   map=new HashMap();
		   map.put("curpage", page);
		   map.put("totalpage", totalpage);
		   map.put("list", list);
		   
		   ObjectMapper mapper=new ObjectMapper();
		   String json=mapper.writeValueAsString(map);
		   return json;
	   }
	@GetMapping(value="recipe/detail_vue.do",produces = "text/plain;charset=UTF-8")
	public String recipe_detail(int no) throws Exception
	{
		RecipeDetailVO vo=dao.recipeDetailData(no);
		List<String> mList=new ArrayList<String>();
		List<String> iList=new ArrayList<String>();
		
		String[] makes=vo.getFoodmake().split("\n");
		for(String m:makes)
		{
			StringTokenizer st=new StringTokenizer(m,"^");
			mList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		
		Map map=new HashMap();
		map.put("vo", vo);
		map.put("mList", mList);
		map.put("iList", iList);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
}
