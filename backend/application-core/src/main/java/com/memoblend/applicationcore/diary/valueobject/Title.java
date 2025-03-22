package com.memoblend.applicationcore.diary.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * タイトルを表す値オブジェクトです。
 */
@Getter
@EqualsAndHashCode
public class Title {
  private final String value;

  /**
   * {@link Title} クラスの新しいインスタンスを初期化します。
   * 
   * @param value タイトルの値。
   * @throws IllegalArgumentException タイトルの値が null か指定の文字数範囲外の場合。
   */
  public Title(String value) {
    if (value == null || value.isEmpty() || value.isBlank()) {
      throw new IllegalArgumentException("{0} は {1} 文字以上入力してください");
    }
    if (value.length() < 1 || value.length() > 30) {
      throw new IllegalArgumentException("{0} は {1} ～ {2} 文字の範囲で入力してください");
    }
    this.value = value;
  }
}
