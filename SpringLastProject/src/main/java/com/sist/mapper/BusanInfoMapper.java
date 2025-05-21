package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface BusanInfoMapper {
	@Select("SELECT no,poster,title,address,phone,num "
			 +"FROM (SELECT no,poster,title,address,phone,rownum as num "
			 +"FROM (SELECT /*+ INDEX_ASC(busan_info bi_no_pk)*/no,poster,title,address,phone "
			 +"FROM busan_info WHERE cno=#{cno})) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	public List<BusanInfoVO> busanInfoListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM busan_info "
			 +"WHERE cno=#{cno}")
	public int busanInfoTotalPage(int cno);
	
	@Select("SELECT * FROM busan_info WHERE no=#{no}")
	public BusanInfoVO busanInfoDetailData(int no);
	
}
