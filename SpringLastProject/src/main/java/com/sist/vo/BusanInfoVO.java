package com.sist.vo;
/*
NO               NUMBER         
CNO              NUMBER         
TITLE   NOT NULL VARCHAR2(500)  
POSTER  NOT NULL VARCHAR2(260)  
ADDRESS NOT NULL VARCHAR2(500)  
PHONE            VARCHAR2(100)  
INFO             VARCHAR2(3000) 
 */

import lombok.Data;

@Data
public class BusanInfoVO {
	private int no,cno;
	private String title,poster,address,phone,info;
}
