package com.memoblend.applicationcore.user;

import com.memoblend.applicationcore.constant.ExceptionIdConstants;
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

  @NotNull(message = ExceptionIdConstants.E_USER_ID_IS_NULL)
  @PositiveOrZero(message = ExceptionIdConstants.E_USER_ID_IS_NEGATIVE)
  private long id;
  
  @NotBlank(message = ExceptionIdConstants.E_USER_NAME_IS_BLANK)
  @Size(min = 1, max = 15, message = ExceptionIdConstants.E_USER_NAME_LENGTH_IS_OUT_OF_RANGE)
  private String name;

  private boolean isDeleted;
}