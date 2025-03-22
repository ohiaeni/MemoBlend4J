package com.memoblend.applicationcore.diary.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * ユーザー ID を表す値オブジェクトです。
 */
@Getter
@EqualsAndHashCode
public class UserId {
  private final long value;

  /**
   * {@link UserId} クラスの新しいインスタンスを初期化します。
   * 
   * @param value ユーザー ID の値。
   */
  public UserId(long value) {
    this.value = value;
  }
}
