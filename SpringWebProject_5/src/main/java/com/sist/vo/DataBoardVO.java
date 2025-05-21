package com.sist.vo;
/*
NO        NOT NULL NUMBER         
NAME      NOT NULL VARCHAR2(52)   
SUBJECT   NOT NULL VARCHAR2(4000) 
CONTENT   NOT NULL CLOB           
PWD       NOT NULL VARCHAR2(10)   
REGDATE            DATE           
HIT                NUMBER         
FILECOUNT          NUMBER 

1. 유지보수 => 한 번에 처리하자
  1) 공통소스: @Aspect
  2) 공통 예외처리: @ControllerAdvice]
2. DAO / SQL
3. Model에서 전송
  ------사용자값 받기 / 전송하는 값
  		  |매개변수     |Model
4. JSP는 변경 사항 없음
 */
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
// 일반 JDBC => 컬럼명과 VO 변수명 일치하지 않아도 됨 => 어차피 setter로 받기 때문
// MyBatis / JPA => 컬럼명과 VO 변수명 일치해야 함 => 안 될 경우 as / resultMap을 모두 사용
public class DataBoardVO {
	private int no,hit,filecount;
	private String name,subject,content,pwd,dbday;
	private Date regdate;
	private List<MultipartFile> files=new ArrayList<MultipartFile>();
	// 여러 개 데이터 : List / String[]
	// => DataBoardVO vo => 업로드 파일까지 값 채워줌
	// List 사용 시 file은 배열식으로 받아야 함 => <input type=file name="files[0]">
}
