package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service// 여러 개 DAO 통합 사용
/*            
 *               @Controller
 *   요청  ====== Model  <=====> Service  <=======> DAO
 *                 |                               |리팩토링
 *              Resolver
 *                 |
 *                JSP
 */
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO rDao;
	@Autowired
	private RecipeDetailDAO dDao;
	
	@Override
	public List<RecipeVO> recipeListData(Map map) {
		// TODO Auto-generated method stub
		return rDao.recipeListData(map);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return rDao.recipeTotalPage();
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		return dDao.recipeDetailData(no);
	}

	@Override
	public List<RecipeVO> recipeFindData(Map map) {
		// TODO Auto-generated method stub
		return rDao.recipeFindData(map);
	}

	@Override
	public int recipeFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return rDao.recipeFindTotalPage(map);
	}

	@Override
	public int chefTotalPage() {
		// TODO Auto-generated method stub
		return rDao.chefTotalPage();
	}

	@Override
	public List<ChefVO> chefListData(Map map) {
		// TODO Auto-generated method stub
		return rDao.chefListData(map);
	}

}
