package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.*;
import com.sist.vo.*;
@RestController
/*
 *   ResponseEntity
 *     寃곌낵媛� / �긽�깭肄붾뱶 (200,400,404,500) / header 媛믪쓣 紐⑤몢 �봽濡좏듃濡� �쟾�넚
 *     �뿉�윭 肄붾뱶瑜� �긽�꽭�븯寃� �쟾�넚 
 *     
 *     => �봽濡좏듃�뿉�꽌 �꽌踰꾩뿉�꽌 諛쏆븘�삩 �뜲�씠�꽣瑜� �솕硫댁뿉 �몴�떆�븷 �븣 �궗�슜
 *     	  �씪諛� �쎒�뿉�꽌 �궗�슜 => promise
 *     	=> �삤瑜섎�� �돺寃� 李얠쓣 �닔 �엳�쓬(�닔�젙 �렪由�)
 */
public class RecipeRestController {
	@Autowired
	private RecipeDAO rDao;
	
	@GetMapping("recipe/list.do")
	// params => 留ㅺ컻蹂��닔 page  /  formData => VO
	public ResponseEntity<Map> recipe_list(int page)
	{	// �뿉�윭 / �젙�긽(status) => �떎�젣 �뜲�씠�꽣 �쟾�넚 蹂닿린
		Map map=new HashMap();
		try
		{
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			List<RecipeVO> list=rDao.recipeListData(start, end);
			int count=rDao.recipeTotalPage();
			int totalpage=(int)(Math.ceil(count/12.0));
			
			int BLOCK=10;
			int startPage=((page-1)/BLOCK*BLOCK)+1;
			int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
			
			if(endPage>totalpage)
				endPage=totalpage;
			
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("count", count);
			
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			// server�뿉�꽌 �궃 �뿉�윭 蹂닿린
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
		// �젙�긽 �닔�뻾 �떆 map�쓣 蹂대궡寃좊떎
	}
	
	@GetMapping("recipe/detail_vue.do")
	public ResponseEntity<Map> recipe_detail(int no)
	{
		Map map=new HashMap();
		try
		{
			RecipeDetailVO vo=rDao.recipeDetailData(no);
			List<String> mlist=new ArrayList<String>();
			List<String> ilist=new ArrayList<String>();
			
			String[] datas=vo.getFoodmake().split("\n");
			for(String s:datas)
			{
				StringTokenizer st=new StringTokenizer(s,"^");
				mlist.add(st.nextToken());
				ilist.add(st.nextToken());
			}
			map.put("vo", vo);
			map.put("mlist", mlist);
			map.put("ilist", ilist);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
				
	}
}
