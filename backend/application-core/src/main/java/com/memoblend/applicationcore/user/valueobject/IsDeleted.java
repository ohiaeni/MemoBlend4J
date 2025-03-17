package com.memoblend.applicationcore.user.valueobject;

import lombok.Data;

/**
 * 削除フラグを表す値オブジェクト。
 */
@Data
public class IsDeleted {
    
  private boolean value;

  /**
   * 削除フラグの値オブジェクトを生成します。
   * @param value 削除フラグ
   */
  public IsDeleted(boolean value) {
    this.value = value;
  }
  
}
