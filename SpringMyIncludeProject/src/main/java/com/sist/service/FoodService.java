package com.sist.service;
import java.util.List;
import java.util.Map;

import com.sist.vo.*;
public interface FoodService {
	public FoodVO foodDetailData(int fno);
	public int foodTotalPage();
	public List<FoodVO> foodListData(Map map);
	public List<FoodVO> foodFindData(Map map);
	public int foodFindTotalPage(Map map);
}
