package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.CommentVO;
import com.sist.dao.*;
@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO cDao;
	
	@Override
	public List<CommentVO> commentListData(Map map) {
		// TODO Auto-generated method stub
		return cDao.commentListData(map);
	}

	@Override
	public int commentTotalPage(int cno, int type) {
		// TODO Auto-generated method stub
		return cDao.commentTotalPage(cno, type);
	}

	@Override
	public void commenInsert(CommentVO vo) {
		// TODO Auto-generated method stub
		cDao.commenInsert(vo);
	}
    /*
     *   Spring 
     *   1. Container : Ŭ���� ������ 
     *   2. DI => Ŭ������ Ŭ������ ���� ���� ����
     *            �������� ���� ���α׷� 
     *            => �������̽� 
     *   3. AOP => ������ 
     *   4. ORM => �����ͺ��̽� ���� ���̺귯�� 
     *             MyBatis / JPA
     *   5. MVC ���� ���� 
     *   6. Spring Security : ���� / �α��� 
     *   7. RestFul
     *   ===============================
     */
	@Override
	public void commentUpdate(String msg, int no) {
		// TODO Auto-generated method stub
		cDao.commentUpdate(msg, no);
	}

	@Override
	public void commentReplyReplyInsert(int pno, CommentVO vo) {
		// TODO Auto-generated method stub
		cDao.commentReplyReplyInsert(pno, vo);
	}

	@Override
	public void commentDelete(int no) {
		// TODO Auto-generated method stub
		cDao.commentDelete(no);
	}
 
}