package com.memoblend.applicationcore.diary;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 日記のドメインモデルです。
 */
@Data
@AllArgsConstructor
public class Diary {

  @NotNull(message = "{0}は必須です")
  @PositiveOrZero(message = "{0}は0以上の値にしてください")
  private long id;

  @NotNull(message = "{0}は必須です")
  @PositiveOrZero(message = "{0}は0以上の値にしてください")
  private long userId;

  @NotBlank(message = "{0}は1～30文字の範囲で入力してください")
  @Size(min = 1, max = 30, message = "{0}は1～30文字の範囲で入力してください")
  private String title;

  @NotBlank(message = "{0}は1文字以上入力してください")
  @Size(min = 1, message = "{0}は1文字以上入力してください")
  private String content;

  @NotNull(message = "{0}は必須です")
  private LocalDate date;

  private boolean isDeleted;
}
