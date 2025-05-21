package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data
public class MemberVO {
	private int enable; // 활성화(1), 휴면계정(0)
	private String userid,userpwd,username,sex,birthday,email,post,addr1,addr2,phone,content,msg,authority;
	private Date regdate,modifydata,lastlogin;
}
