package com.sist.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
import com.sist.vo.*;
public interface DataBoardMapper {
	// 인라인뷰 단점: Top-N이다(데이터를 중간부터 자를 수가 없다) => select 문장을 계속해서 만드는 이유
	// 자바에서 잘라도 되잖아? => 그럼 for문이 계속 진행되어야 하니 속도가 느려짐
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'yyyy-MM-dd') as dbday,hit,replycount,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,replycount,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit,replycount "
			+ "FROM vueDataBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> databoardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM vueDataBoard")
	public int databoardTotalPage();
	
	@Insert("INSERT INTO vueDataBoard VALUES("
			+ "vb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},SYSDATE,0,#{filename},#{filesize},#{filecount},0)")
	public void databoardInsert(DataBoardVO vo);
	
	@Update("UPDATE vueDataBoard SET hit=hit+1 WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'yyyy-MM-dd') as dbday,filename,filesize,filecount "
			+ "FROM vueDataBoard WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
}
