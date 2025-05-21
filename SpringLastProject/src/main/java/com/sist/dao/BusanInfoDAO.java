package com.sist.dao;
import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BusanInfoDAO {
	@Autowired
	private BusanInfoMapper mapper;
	
	public List<BusanInfoVO> busanInfoListData(Map map)
	{
		return mapper.busanInfoListData(map);
	}
	public int busanInfoTotalPage(int cno)
	{
		return mapper.busanInfoTotalPage(cno);
	}
	public BusanInfoVO busanInfoDetailData(int no)
	{
		return mapper.busanInfoDetailData(no);
	}
}
