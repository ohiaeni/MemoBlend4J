package com.memoblend.applicationcore.diary.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 削除フラグを表す値オブジェクト。
 */
@Getter
@EqualsAndHashCode
public class IsDeleted {
  private final boolean value;

  /**
   * {@link IsDeleted} クラスの新しいインスタンスを初期化します。
   * 
   * @param value 削除フラグの値。
   */
  public IsDeleted(boolean value) {
    this.value = value;
  }
}
