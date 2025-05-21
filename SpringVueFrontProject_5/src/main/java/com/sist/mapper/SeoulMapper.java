package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface SeoulMapper {
	@Select("SELECT no,title,poster,num "
			+ "FROM (SELECT no,title,poster,rownum as num "
			+ "FROM (SELECT no,title,poster "
			+ "FROM ${table_name} ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulVO> seoulListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM ${table_name}")
	public int seoulTotalPage(Map map);
	// $ => 일반 문자열 X
	
	@Select("SELECT * FROM ${table_name} "
			+ "WHERE no=#{no}")
	public SeoulVO seoulDetailData(Map map);
}
