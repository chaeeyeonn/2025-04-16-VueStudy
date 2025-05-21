package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	/*
	 * @Select("SELECT fno,name,poster,num "
			+ "FROM(SELECT fno,name,poster,rownum as num "
			+ "FROM(SELECT /*+ INDEX_ASC(fno fm_fno_pk) fno,name,poster "
			+ "FROM food_menupan "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menupan")
	public int foodTotalPage();
	
	@Select("SELECT * FROM food_menupan WHERE fno=#{fno})")
	public FoodVO foodDetailData(int fno);
	 */
	public List<FoodVO> foodListData(Map map)
	{
		return mapper.foodListData(map);
	}
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map); 
	}
	public int foodFindTotalPage(Map map)
	{
		return mapper.foodFindTotalPage(map);
	}
}
