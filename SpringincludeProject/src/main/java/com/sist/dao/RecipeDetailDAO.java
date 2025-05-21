package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeDetailMapper;
import com.sist.vo.RecipeDetailVO;

@Repository
public class RecipeDetailDAO {
	@Autowired
	private RecipeDetailMapper mapper;
	
	/*
	 * @Select("SELECT * FROM recipeDetail WHERE no=#{no}")
	public RecipeDetailVO recipeDetailData(int no);
	 */
	public RecipeDetailVO recipeDetailData(int no)
	{
		return mapper.recipeDetailData(no);
	}
}
