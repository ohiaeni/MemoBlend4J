package com.memoblend.applicationcore.user.valueobject;

import com.memoblend.applicationcore.constant.ExceptionIdConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * ユーザーの名前を表す値オブジェクト。
 */
@Getter
@EqualsAndHashCode
public class Name {

  private final String value;

  /**
   * 名前の値オブジェクトを生成します。
   * 
   * @param value ユーザーの名前。
   * @throws IllegalArgumentException 名前が不正な場合。
   */
  public Name(String value) {
    if (value == null) {
      throw new IllegalArgumentException(ExceptionIdConstants.E_USER_NAME_IS_NULL);
    }
    if (value.isBlank()) {
      throw new IllegalArgumentException(ExceptionIdConstants.E_USER_NAME_IS_BLANK);
    }
    if (value.length() < 1 || value.length() > 15) {
      throw new IllegalArgumentException(ExceptionIdConstants.E_USER_NAME_LENGTH_IS_OUT_OF_RANGE);
    }
    this.value = value;
  }

}
