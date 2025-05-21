package com.sist.vo;

import lombok.Data;

// seoul-location / seoul-nature / seoul-shop / seoul-food
@Data
public class SeoulVO {
	private int no,hit,likecount,replycount;
	private String title,poster,msg,address;
}
