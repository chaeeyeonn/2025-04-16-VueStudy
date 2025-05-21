package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	/*
	 * @Select("SELECT no,goods_poster,goods_name,goods_price,num "
			  +"FROM (SELECT no,goods_poster,goods_name,goods_price,rownum as num "
			  +"FROM (SELECT no,goods_poster,goods_name,goods_price "
			  +"FROM goods_all ORDER BY no ASC)) "
			  +"WHERE num BETWEEN #{start} AND #{end}")
	   public List<GoodsVO> busanGoodsListData(
			   @Param("start") int start,
			   @Param("end") int end);
	   @Select("SELECT CEIL(COUNT(*)/20.0) FROM goods_all")
	   public int busanGoodsTotalPage();
	   @Select("SELECT * FROM goods_all WHERE no=#{no}")
	   public GoodsVO busanGoodsDetailData(int no);
	 */
	public List<GoodsVO> busanGoodsListData(int start,int end)
	{
		return mapper.busanGoodsListData(start, end);
	}
	public int busanGoodsTotalPage()
	{
		return mapper.busanGoodsTotalPage();
	}
	public GoodsVO busanGoodsDetailData(int no)
	{
		return mapper.busanGoodsDetailData(no);
	}
}
