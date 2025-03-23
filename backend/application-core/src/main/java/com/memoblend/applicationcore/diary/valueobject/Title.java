package com.memoblend.applicationcore.diary.valueobject;

import com.memoblend.applicationcore.constant.ExceptionIdConstants;
import com.memoblend.applicationcore.diary.DiaryValidationException;
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
   * @throws DiaryValidationException タイトルが不正な場合。
   */
  public Title(String value) throws DiaryValidationException {
    if (value == null || value.isEmpty() || value.isBlank()) {
      throw new DiaryValidationException(
          ExceptionIdConstants.E_DIARY_FIELD_IS_REQUIRED,
          new String[] { String.valueOf("タイトル") },
          new String[] { String.valueOf("タイトル") });
    }
    if (value.length() <= 1 || value.length() >= 30) {
      throw new DiaryValidationException(
          ExceptionIdConstants.E_DIARY_VALUE_IS_OUT_OF_RANGE,
          new String[] { String.valueOf("タイトル"), "1", "30" },
          new String[] { String.valueOf("タイトル"), "1", "30" });
    }
    this.value = value;
  }
}
