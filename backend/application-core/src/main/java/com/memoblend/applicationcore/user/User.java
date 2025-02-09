package com.memoblend.applicationcore.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザーのドメインモデルです。
 */
@Data
@AllArgsConstructor
public class User {
  @NotNull
  @NotBlank
  private long id;

  @NotNull
  @NotBlank
  @Size(min = 1, max = 15, message = "{0}は1～15文字の範囲で入力してください")
  private String name;
}
