package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data
public class MemberVO {
	private int enable; // Ȱ��ȭ(1), �޸����(0)
	private String userid,userpwd,username,sex,birthday,email,post,addr1,addr2,phone,content,msg,authority;
	private Date regdate,modifydata,lastlogin;
}
