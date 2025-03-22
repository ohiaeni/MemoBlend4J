package com.memoblend.applicationcore.user.valueobject;

import com.memoblend.applicationcore.constant.ExceptionIdConstants;
import com.memoblend.applicationcore.user.UserValidationException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * ユーザーの名前を表す値オブジェクトです。
 */
@Getter
@EqualsAndHashCode
public class Name {

  private final String value;

  /**
   * {@link Name} クラスの新しいインスタンスを初期化します。
   * 
   * @param value ユーザー名。
   * @throws UserValidationException ユーザー名が不正な場合。
   */
  public Name(String value) throws UserValidationException {
    if (value == null || value.isEmpty() || value.isBlank()) {
      throw new UserValidationException(
          ExceptionIdConstants.E_USER_FIELD_IS_REQUIRED,
          new String[] { String.valueOf("ユーザー名") },
          new String[] { String.valueOf("ユーザー名") });
    }
    if (value.length() <= 1 || value.length() >= 15) {
      throw new UserValidationException(
          ExceptionIdConstants.E_USER_VALUE_IS_OUT_OF_RANGE,
          new String[] { String.valueOf("ユーザー名"), "1", "15" },
          new String[] { String.valueOf("ユーザー名"), "1", "15" });
    }
    this.value = value;
  }

}
