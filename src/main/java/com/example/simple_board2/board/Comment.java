package com.example.simple_board2.board;

import lombok.*;

import java.time.*;

@Getter
@Setter
@ToString
public class Comment {
  private Integer cno;
  private String content;
  private String nickname;
  private String password;
  private LocalDateTime writeTime;
  private Integer bno;
}
