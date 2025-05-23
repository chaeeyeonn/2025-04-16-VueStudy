package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.FoodVO;
@Repository
public class VueDAO {
	@Autowired
	private VueMapper mapper;
	
	/*
	 * @Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT fno,name,poster "
			+ "FROM project_food ORDER BY fno ASC "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	 */
	public List<FoodVO> foodListData(Map map)
	{
		return mapper.foodListData(map);
	}
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
}
