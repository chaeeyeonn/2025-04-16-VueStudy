package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.GoodsVO;
@Repository
public class GoodsDAO {
/*
 * @Select("SELECT no,goods_name,goods_price,goods_sub,goods_poster,num "
			+"FROM(SELECT no,goods_name,goods_price,goods_sub,goods_poster,rownum as num "
			+ "FROM(SELECT no,goods_name,goods_price,goods_sub,goods_poster "
			+ "FROM goods_all))")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT * FROM goods_all WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
 */
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsListData(Map map)
	{
		return mapper.goodsListData(map);
	}
	public GoodsVO goodsDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.goodsDetailData(no);
	}

    
	  public int goodsTotalPage()
	  {
    	return mapper.goodsTotalPage();
	  }
}
