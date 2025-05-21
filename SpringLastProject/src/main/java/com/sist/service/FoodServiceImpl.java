package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.FoodVO;
import com.sist.dao.*;
// �������� ���� / DAO�������� �����ؼ� ���
/*
 *   @Component, 
 *   @Repository, 
 *   @Service, 
 *   @Controller, 
 *   @RestController, 
 *   @ControllerAdvice, 
     @Configuration
 */
@Service
public class FoodServiceImpl implements FoodService {
    
	@Autowired
	private FoodDAO fDao;
	
	@Override
	public List<FoodVO> busanFoodListData(int start, int end) {
		// TODO Auto-generated method stub
		return fDao.busanFoodListData(start, end);
	}

	@Override
	public int busanFoodTotalPage() {
		// TODO Auto-generated method stub
		return fDao.busanFoodTotalPage();
	}

	@Override
	public FoodVO busanFoodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.busanFoodDetailData(fno);
	}

}