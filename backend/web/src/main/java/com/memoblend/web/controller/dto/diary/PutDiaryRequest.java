package com.memoblend.web.controller.dto.diary;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 日記の更新リクエストクラスです。
 */
@Data
@AllArgsConstructor
public class PutDiaryRequest {
  private long id;
  private long userId;
  private String title;
  private String content;
  private LocalDate createdDate;
}
