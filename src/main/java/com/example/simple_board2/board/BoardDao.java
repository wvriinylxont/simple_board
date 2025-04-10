package com.example.simple_board2.board;

import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface BoardDao {
  @SelectKey(statement = "select board_seq.nextval from dual", keyProperty = "bno", resultType = Integer.class, before = true)
  @Insert("insert into board(bno, title, content, nickname, password) values(#{bno}, #{title}, #{content}, #{nickname}, #{password})")
    // @SelectKey로 생성한 글번호를 리턴하는 save
  public void save(Board board);
  // 글 전체를 리턴하는 findAll
  @Select("select * from board order by bno desc")
  public List<Board> findAll();
  // 글 1개를 리턴하는 findByBno
  @Select("select * from board where bno=#{bno} and rownum=1")
  public Board findByBno(int bno);
  // 글 조회수를 증가하는 increaseReadCnt
  @Update("update board set readCnt=readCnt+1 where bno=#{bno} and rownum=1")
  public void increaseReadCnt(int bno);
  // 제목과 글 내용을 업데이트하는 update
  @Update("update board set title=#{title}, content=#{content} where bno=#{bno} and rownum=1")
  public void update(Board board);
  // 글을 삭제하는 delete
  @Delete("delete from board where bno=#{bno} and rownum=1")
  public void delete(int bno);
}