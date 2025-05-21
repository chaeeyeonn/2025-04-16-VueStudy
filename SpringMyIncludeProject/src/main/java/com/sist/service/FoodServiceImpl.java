package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO fDao;

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodDetailData(fno);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return fDao.foodTotalPage();
	}

	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodListData(map);
	}

	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodFindData(map);
	}

	@Override
	public int foodFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodFindTotalPage(map);
	}
}
