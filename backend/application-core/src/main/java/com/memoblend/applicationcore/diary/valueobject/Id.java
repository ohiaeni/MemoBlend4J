package com.memoblend.applicationcore.diary.valueobject;

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
   * @param value ID の値。
   * @throws IllegalArgumentException ID の値が 0 未満の場合。
   */
  public Id(long value) {
    if (value < 0) {
      throw new IllegalArgumentException("{0} は {1} 以上の値にしてください");
    }
    this.value = value;
  }
}