package com.sist.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsVO;

public interface GoodsService {
	public List<GoodsVO> goodsListData(Map map);
	
	public GoodsVO goodsDetailData(int no);
	
	public int goodsTotalPage();
	
}
