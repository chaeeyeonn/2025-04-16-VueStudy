package com.sist.dao;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	/*
	 * @Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX ASC(food_menupan fm_fno_pk)fno,name,poster "
			+ "FROM food_menupan)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0 FROM food_menupan")
	public int foodTotalPage();
	 */
	public List<FoodVO> foodListData(int start,int end)
	{
		return mapper.foodListData(start, end);
	}
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	/*
	 * @Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX ASC(food_menupan fm_fno_pk)fno,name,poster "
			+ "FROM food_menupan)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menupan")
	public int foodFindTotalPage();
	 */
	public List<FoodVO> foodFindListData(Map map)
	{
		return mapper.foodFindListData(map);
	}
	public int foodFindTotalPage(String fd)
	{
		return mapper.foodFindTotalPage(fd);
	}
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
}
