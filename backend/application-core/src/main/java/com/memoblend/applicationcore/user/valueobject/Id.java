package com.memoblend.applicationcore.user.valueobject;

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
   * {@link Id} クラスの新しいインスタンスを初期化します。
   * 
   * @param value ユーザーの ID 。
   */
  public Id(long value) {
    this.value = value;
  }
}