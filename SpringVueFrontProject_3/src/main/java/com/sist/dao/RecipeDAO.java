package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData()
	{
		return mapper.recipeListData();
	}
}
