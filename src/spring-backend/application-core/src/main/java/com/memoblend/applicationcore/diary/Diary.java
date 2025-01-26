package com.memoblend.applicationcore.diary;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 日記のドメインモデルです。
 */
@Data
@AllArgsConstructor
public class Diary {

  @NotNull
  @NotBlank
  private long id;

  @NotNull
  @NotBlank
  private long userId;

  @NotNull
  @NotBlank
  @Size(min = 1, max = 4, message = "{0}は1～30文字の範囲で入力してください")
  private String title;

  @NotNull
  @NotBlank
  @Size(min = 1, message = "{0}は1文字以上入力してください")
  private String content;

  @NotNull
  @NotBlank
  private LocalDate date;
}
