package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	/*
	 * @Select("SELECT no,poster,title,num "
			+ "FROM (SELECT no,poster,title,ronum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)no,poster,title "
			+ "FROM recipe WHERE no IN (SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE no IN (SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
	public int recipeTotalPage();
	 */
	public List<RecipeVO> recipeListData(int start,int end)
	{
		return mapper.recipeListData(start, end);
	}
	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}
	/*
	 * @Select("SELECT no,poster,title,num "
			+ "FROM (SELECT no,poster,title,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)no,poster,title "
			+ "FROM recipe WHERE title LIKE '%'||#{fd}||'%'))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeFindListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE title LIKE '%'||#{fd}||'%'")
	public int recipeFindTotalPage(String fd);
	 */
	public List<RecipeVO> recipeFindListData(Map map)
	{
		return mapper.recipeFindListData(map);
	}
	public int recipeFindTotalPage(String fd)
	{
		return mapper.recipeFindTotalPage(fd);
	}
	
	public RecipeDetailVO recipeDetailData(int no)
	{
		return mapper.recipeDetailData(no);
	}
}
