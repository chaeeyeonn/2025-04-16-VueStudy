package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public MemberVO memberInfoData(String userid)
	{
		return mapper.memberInfoData(userid);
	}
}
