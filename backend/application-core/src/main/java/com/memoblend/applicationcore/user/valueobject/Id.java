package com.memoblend.applicationcore.user.valueobject;

import com.memoblend.applicationcore.constant.ExceptionIdConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * ID を表す値オブジェクト。
 */
@Getter
@EqualsAndHashCode
public class Id {
  
  private final long value;

  /**
   * ID の値オブジェクトを生成します。
   * 
   * @param value ユーザーの ID（0以上）
   * @throws IllegalArgumentException ID が負の値の場合
   */
  public Id(long value) {
    if (value < 0) {
      throw new IllegalArgumentException(ExceptionIdConstants.E_USER_ID_IS_NEGATIVE);
    }
    this.value = value;
  }

}