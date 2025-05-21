package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;
/*
 * /*
NO                NOT NULL NUMBER         
GOODS_NAME        NOT NULL VARCHAR2(1000) 
GOODS_SUB                  VARCHAR2(1000) 
GOODS_PRICE       NOT NULL VARCHAR2(50)   
GOODS_DISCOUNT             NUMBER         
GOODS_FIRST_PRICE          VARCHAR2(20)   
GOODS_DELIVERY    NOT NULL VARCHAR2(20)   
GOODS_POSTER               VARCHAR2(260)  
HIT                        NUMBER         
LIKECOUNT                  NUMBER         
REPLYCOUNT                 NUMBER  
 */

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
public class GoodsMapper {
	@Select("SELECT no,goods_name,goods_price,goods_sub,goods_poster,num "
			+"FROM(SELECT no,goods_name,goods_price,goods_sub,goods_poster,rownum as num "
			+ "FROM(SELECT no,goods_name,goods_price,goods_sub,goods_poster "
			+ "FROM goods_all))")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT * FROM goods_all WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
	@Update("UPDATE goods_all SET "
			  +"hit=hit+1 "
			  +"WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
}
