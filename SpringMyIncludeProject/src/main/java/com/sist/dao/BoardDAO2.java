package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;

@Repository
public class BoardDAO2 {
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(int page)
	{
		return mapper.boardListData(page);
	}
	public int boardRowCount()
	{
		return mapper.boardRowCount();
	}
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
}
