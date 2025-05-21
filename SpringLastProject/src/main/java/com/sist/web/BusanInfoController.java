package com.sist.web;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*
 *    7:3 => 6:4 
 *    => �˻� , ������ , ��� , ���� , ���� 
 *    
 *    = �����ͺ��̽� ���� => Service/DAO 
 *    = ������ ���� => Model (ȭ��,�����͸� ����)
 *    
 *                      | ��� : web.xml
 *                        => HandelrMapping ���� 
 *                        => Ŭ���� ��� => xml�� ����
 *                      | �ڵ� ���� / ��Ĺ �ڵ� ���� => Spring-Boot 
 *    ����� ��û (.do) ==> DispatcherServlet 
 *                            |
 *                         HandlerMapping : Model�� ã�Ƽ� ��� ����
 *                            |
 *                          ViewResolver : JSP�� ã�Ƽ� request����
 *                            | ��θ�/Ȯ����
 *                          JSP
 */
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.BusanInfoService;
import com.sist.vo.BusanInfoVO;
@Controller
public class BusanInfoController {
  // @Autowired => �������� ������ ���� 
  // �ʿ��� ��ü => ���������� �޸� �Ҵ��� ��� 
  @Autowired
  private BusanInfoService service;
  
  private String[] titles={"","���","����","����"};
  // HandlerMapping�� ã�� => ��� ���� 
  @GetMapping("busan/info.do")
  public String busan_info(int cno,Model model)
  {
	  // include�� ���� ���� 
	  model.addAttribute("cno", cno);
	  model.addAttribute("titles", titles[cno]);
	  model.addAttribute("main_jsp", "../busan/info_list.jsp");
	  return "main/main";
  }
  // �� => ����ڰ� ������ �� <a> <form> params(Vue,React) / data(Ajax)
  // ����Ҷ� �޾Ƽ� JSP���� ��º��� => model.addAttribute() , data(){}
  // �ְ� �ޱ� 
  // => useState(React)
  @GetMapping("busan/detail.do")
  public String busan_detail(int no,Model model,HttpSession session)
  {
	  String id=(String)session.getAttribute("userid");
	  BusanInfoVO vo=service.busanInfoDetailData(no);
	  String addr1=vo.getAddress();
	  addr1=addr1.substring(addr1.indexOf(" "));
	  String addr2=addr1.trim();
	  addr2=addr2.substring(0,addr2.indexOf(" "));
	  model.addAttribute("vo", vo);
	  model.addAttribute("sessionId", id);
	  model.addAttribute("addr", addr2);
	  model.addAttribute("main_jsp", "../busan/info_detail.jsp");
	  return "main/main";
  }
}