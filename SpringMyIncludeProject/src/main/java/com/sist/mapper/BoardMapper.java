package com.sist.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface BoardMapper {
	String sql1="SELECT no,subject,name,hit,regdate,num "
			  +"FROM (SELECT no,subject,name,hit,regdate,rownum as num "
			  +"FROM (SELECT no,subject,name,hit,regdate "
			  +"FROM springReplyBoard ORDER BY no DESC)) "
			  +"WHERE num BETWEEN #{start} AND #{end}";
	@Select(sql1)
	public List<BoardVO> boardListData(int page);
	
	@Select("SELECT COUNT(*) FROM springReplyBoard")
	public int boardRowCount();
	
	String sql2="INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id) "
			+ "VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},(SELECT NVL(MAX(group_id)+1,1) "
			+ "FROM springReplyBoard))";
	@Insert(sql2)
	public void boardInsert(BoardVO vo);
	
	@Update("UPDATE springReplyBoard SET hit=hit+1 WHERE no=#{no}")
	public void hitIncrement(int no);
	
	String sql3="SELECT no,name,subject,content,hit,regdate "
				+"FROM springReplyBoard "
				+"WHERE no=#{no}";
	@Select(sql3)
	public BoardVO boardDetailData(int no);
	
}
