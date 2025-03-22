package com.memoblend.applicationcore.user.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 削除フラグを表す値オブジェクトです。
 */
@Getter
@EqualsAndHashCode
public class IsDeleted {

  private final boolean value;

  /**
   * {@link IsDeleted} クラスの新しいインスタンスを初期化します。
   * 
   * @param value 削除フラグ。
   */
  public IsDeleted(boolean value) {
    this.value = value;
  }

}
