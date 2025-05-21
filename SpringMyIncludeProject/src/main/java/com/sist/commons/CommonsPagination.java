package com.sist.commons;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
public class CommonsPagination {
	public static Map pageConfig(String page,int rowSize)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		map.put("curpage", curpage);
		return map;
	}
}
