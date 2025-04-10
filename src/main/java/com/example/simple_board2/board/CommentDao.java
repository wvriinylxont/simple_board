package com.example.simple_board2.board;

import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface CommentDao {
  // 추가
  @Insert("insert into comments values(comments_seq.nextval, #{content},#{nickname}, #{password}, sysdate, #{bno})")
  int save(Comment comment);

  // 오라클 hint를 이용한 삭제byCno
  @Delete("delete from comments where cno=#{cno} and rownum=1")
  int deleteByCno(int cno);

  //삭제byBno
  @Delete("delete from comments where bno=#{bno}")
  int deleteByBno(int bno);

  //목록
  @Select("select * from comments where bno=#{bno}")
  List<Comment> findByBno(int bno);
}
