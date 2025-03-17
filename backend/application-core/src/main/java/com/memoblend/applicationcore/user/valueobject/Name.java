package com.memoblend.applicationcore.user.valueobject;

import com.memoblend.applicationcore.constant.ExceptionIdConstants;
import lombok.Data;

/**
 * ユーザーの名前を表す値オブジェクト。
 */
@Data
public class Name {
    
  private String value;

  /**
   * 名前の値オブジェクトを生成します。
   * @param value ユーザーの名前
   * @throws IllegalArgumentException 
   */
  public Name(String value) {
    if (value == null) {
      throw new IllegalArgumentException(ExceptionIdConstants.E_USER_NAME_IS_NULL);
    }
    if (value.contains(" ")) {
      throw new IllegalArgumentException(ExceptionIdConstants.E_USER_NAME_IS_BLANK);
    }
    if (value.length() < 1 || value.length() > 15) {
      throw new IllegalArgumentException(ExceptionIdConstants.E_USER_NAME_LENGTH_IS_OUT_OF_RANGE);
    }
    this.value = value;
  }

}
