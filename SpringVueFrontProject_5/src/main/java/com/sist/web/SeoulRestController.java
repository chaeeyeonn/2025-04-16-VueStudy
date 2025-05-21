package com.sist.web;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;
@RestController
public class SeoulRestController {
	// 필요한 객체 => 데이터베이스 연동 => ~DAO
	@Autowired
	private SeoulDAO dao;
	
	private String[] tables= {
		"","seoul_location","seoul_nature","seoul_shop","seoul_food"	
	};
	/*
	 * @Autowired // 매개변수로 받는 형식 => private 노출되지 않도록 생성자 속에서 받아라 => 현직에서 쓰는 방법
	 * public SeoulRestController(SeoulDAO dao) { 
	 * 		this.dao=dao; 
	 * }
	 */
	private String[] titles= {
		"","서울 명소","서울 자연","서울 쇼핑","서울 음식"	
	};
	@GetMapping(value="seoul/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String seoul_list(int page,int type) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		Map map=new HashMap();
		// #{start} ${table_name} 변수명이 일치해야 함 => key name
		map.put("table_name", tables[type]);
		map.put("start", start);
		map.put("end", end);
		
		List<SeoulVO> list=dao.seoulListData(map);
		int totalpage=dao.seoulTotalPage(map);
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		map=new HashMap();
		map.put("curpage", page);
		map.put("list", list);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("titles", titles[type]);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value="seoul/detail_vue.do",produces = "text/plain;charset=UTF-8")
	public String seoul_detail(int no,int type) throws Exception
	{
		Map map=new HashMap();
		map.put("no", no);
		map.put("table_name", tables[type]);
		SeoulVO vo=dao.seoulDetailData(map);
		
		// 주소를 따로 받기 위함 => 카카오맵때문에
		String address=vo.getAddress();
		address=address.substring(address.indexOf(" ")+1);
		map=new HashMap();
		map.put("vo", vo);
		map.put("address",address.trim());
		   
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
}
