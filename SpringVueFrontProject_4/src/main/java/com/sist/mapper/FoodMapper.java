package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX ASC(food_menupan fm_fno_pk)*/fno,name,poster "
			+ "FROM food_menupan)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menupan")
	public int foodTotalPage();
	
	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX ASC(food_menupan fm_fno_pk)*/fno,name,poster "
			+ "FROM food_menupan WHERE address LIKE '%'||#{fd}||'%')) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menupan WHERE address LIKE '%'||#{fd}||'%'")
	public int foodFindTotalPage(String fd);
	
	@Select("SELECT * FROM food_menupan WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
