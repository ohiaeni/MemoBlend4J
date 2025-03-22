package com.memoblend.applicationcore.user.valueobject;

import com.memoblend.applicationcore.constant.ExceptionIdConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * ID を表す値オブジェクトです。
 */
@Getter
@EqualsAndHashCode
public class Id {

  private final long value;

  /**
   * ID の値オブジェクトを生成します。
   * 
   * @param value ユーザーの ID 。
   * @throws IllegalArgumentException ID が 0 未満の場合。
   */
  public Id(long value) {
    if (value < 0) {
      throw new IllegalArgumentException(ExceptionIdConstants.E_USER_ID_IS_NEGATIVE);
    }
    this.value = value;
  }

}