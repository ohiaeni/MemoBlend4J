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
  private long id;
  private long userId;
  private String title;
  private String content;
  private LocalDate createdDate;
}
