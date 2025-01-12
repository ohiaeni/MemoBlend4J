package com.memoblend.web.controller.dto.diary;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 日記の投稿リクエストクラスです。
 */
@Data
@AllArgsConstructor
public class PostDiaryRequest {
  private LocalDate date;
  private String title;
  private String content;

  public PostDiaryRequest(LocalDate date, String title, String content) {
    this.date = new DiaryDateValue();
    this.date.setValue(date);
    this.title = new DiaryTitleValue();
    this.title.setValue(title);
    this.content = new DiaryContentValue();
    this.content.setValue(content);
  }
}
