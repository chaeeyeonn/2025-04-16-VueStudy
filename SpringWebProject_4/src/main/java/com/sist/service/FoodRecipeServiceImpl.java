package com.sist.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Service
public class FoodRecipeServiceImpl implements FoodRecipeService{
	@Autowired
	private FoodDAO fDao;
	
	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodListData(map);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodDetailData(fno);
	}
	
	@Override
    public int foodTotalPage() {
		return fDao.foodTotalPage();
	}

}
