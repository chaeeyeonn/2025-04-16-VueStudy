package com.sist.vo;

import java.sql.Date;

import lombok.*;

@Data
public class BoardVO {
	private int no,hit;
	private String name,subject,content,pwd,dbday;
	private Date regdate;
}
