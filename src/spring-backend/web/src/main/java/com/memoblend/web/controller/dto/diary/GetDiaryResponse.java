package com.memoblend.web.controller.dto.diary;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 日記の取得レスポンスクラスです。
 */
@Data
@AllArgsConstructor
public class GetDiaryResponse {
  private LocalDate date;
  private long diaryId; 
  private String title;
  private String content;
  private long userId;
}
