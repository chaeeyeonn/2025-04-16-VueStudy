package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 *   Mapper 
 *   --------------------
 *          |
 *       BoardDAO
 *          |
 *       Model => JSP
 *       
 *       1. request: ���� ������ ������� ����
 *       	-------
 *       	- ��û�� �ޱ�	==> �Ű�����
 *       					------���� ���x
 *       						=> ó���ϴ� ���� ��ü�� �޾� ó�� ����
 *       						   (request/response/session/...)
 *       	- JSP�� �� �����ϱ� => Model
 *       
 *       2. �⺻ Ʋ => ���κ���
 *       			 -------
 *       			 �� �´� ��ǰ �����
 *       	DispatcherServlet : ��û / ����
 *          => web.xml
 *          HandlerMapping: �� ã��(@RequestMapping ã�� �޼ҵ� ȣ��)
 *          ViewResolver: �����(request)�� JSP�� ���� => ��θ�, Ȯ���� �ʿ�
 *          			=> application-context.xml
 *          
 *       3. JSP => ������� ����
 *       
 *       => �Ű�����?
 *       request ����: return "jsp ���ϸ�" => forward
 *       request ������: return "redirct:" => sendRedirect
 */
@Controller  //  forward / sendRedirect
@RequestMapping("board/")
// 전역으로 쓰였기 때문에 뒷부분은 board/가 들어가지 않음
public class BoardController {
	
	@Autowired
    private BoardDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("list.do")
	public String board_list(String page,Model model)
	{
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		List<BoardVO> list=dao.boardListData((10*curpage)-9, curpage*10);
		int totalpage=dao.boardTotalPage();
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	@RequestMapping("insert_ok.do")
	public String board_insert_ok(BoardVO vo)
	{
		String pwd=encoder.encode(vo.getPwd());
		vo.setPwd(pwd);
		System.out.println("pwd="+pwd);
		dao.boardInsert(vo);
		// => if(pwd.matchs(vo.getPwd())
		
		return "redirect:list.do";
	}
	// �󼼺��� ��û
	@RequestMapping("detail.do")
	// �������� => String ����, �� �����������ε� ���� �� �ִ�
	// ó�� ���ۿ� �����Ͱ� ���� ���: String 
	public String board_detail(int no,Model model)
	{
		//model => ���� ��ü: request ��ü
		/*
		 *  request => Cookie �� ��
		 */
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo", vo);
		return "board/detail";
		// .. ���� ����
	}
	// 수정 / 삭제
	/*
	 *  메소드명 상관X => 중복만 아니면 됨
	 *  
	 */
	@RequestMapping("update.do")
	public String board_update(int no,Model model)
	{
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo",vo);
		return "board/update";
	}
	/*@RequestMapping("update_ok.do")
	public String board_update_ok(BoardVO vo,Model model)
	{
		boolean bCheck=dao.boardUpdate(vo);
		model.addAttribute("bCheck",bCheck);
		model.addAttribute("no",vo.getNo());
		
		return "board/update_ok";
	}*/
	/*@RequestMapping("update_ok.do")
	@ResponseBody => 승격(한글 안 깨지게) => 
	// out.write() => 자바스크립트,JSON,일반 문자열 전송
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
			result="<script>"
					+"location.href=\"detail.do?no="+vo.getNo()+"\""
					+"</script>";
		}
		else
		{
			result="<script>"
					+"alert(\"Password Fail\");"
					+"history.back();"
					+"</script>";
		}
		return result;
	}*/
	@RequestMapping("delete.do")
	// 매개변수 - url 데이터형이 다른 경우 400 Bad request 뜸
	public String board_delete(int no,Model model)
	{
		model.addAttribute("no",no);
		return "board/delete";
	}
}








