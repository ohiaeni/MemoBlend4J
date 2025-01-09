package com.memoblend.applicationcore.diary;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 日記のドメインモデルです。
 */
@Data
@AllArgsConstructor
public class Diary {
  private LocalDate date;
  private String title;
  private String content;
}
