package com.memoblend.applicationcore.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザーのドメインモデルです。
 */
@Data
@AllArgsConstructor
public class User {

  @NotNull(message = "{0}は必須です")
  @PositiveOrZero(message = "{0}は0以上の値にしてください")
  private long id;

  @NotBlank(message = "{0}は1～15文字の範囲で入力してください")
  @Size(min = 1, max = 15, message = "{0}は1～15文字の範囲で入力してください")
  private String name;
}
