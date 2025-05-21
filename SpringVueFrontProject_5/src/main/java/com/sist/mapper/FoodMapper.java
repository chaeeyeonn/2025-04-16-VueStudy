package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT fno,name,poster "
			+ "FROM food_menupan WHERE type LIKE '%'||#{type}||'%')) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menupan")
	public int foodTotalPage();
	
	@Select("SELECT * FROM food_menupan "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
