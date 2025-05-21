package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;
import java.util.*;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+ "FROM(SELECT fno,name,poster,rownum as num "
			+ "FROM(SELECT /*+ INDEX_ASC(fno fm_fno_pk) */fno,name,poster "
			+ "FROM food_menupan)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menupan")
	public int foodTotalPage();
	
	@Select("SELECT * FROM food_menupan WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	/*
	 * <select id="foodFindData" resultType="com.sist.vo.FoodVO" parameterType="hashmap">
    SELECT no,poster,title,chef,num
    FROM (SELECT fno,poster,name,rownum as num
    FROM (SELECT no,poster,name 
    FROM food_menupan WHERE title LIKE '%'||#{fd}||'%'))
    WHERE num BETWEEN #{start} AND #{end}
  </select> 
  <select id="foodFindTotalPage" resultType="int" parameterType="hashmap">
    SELECT CEIL(COUNT(*)/12.0) FROM food_menupan
    WHERE REGEXP_LIKE(title,#{fd}) 
  </select>
	 */
	public List<FoodVO> foodFindData(Map map);
	public int foodFindTotalPage(Map map);
}