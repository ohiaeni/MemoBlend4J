package com.memoblend.applicationcore.user.valueobject;

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
   * 削除フラグの値オブジェクトを生成します。
   * @param value 削除フラグ
   */
  public IsDeleted(boolean value) {
    this.value = value;
  }
  
}
