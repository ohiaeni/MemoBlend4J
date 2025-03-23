package com.memoblend.applicationcore.diary.valueobject;

import java.time.LocalDate;
import com.memoblend.applicationcore.constant.ExceptionIdConstants;
import com.memoblend.applicationcore.diary.DiaryValidationException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 作成日時を表す値オブジェクトです。
 */
@Getter
@EqualsAndHashCode
public class CreatedDate {
  private final LocalDate value;

  /**
   * {@link CreatedDate} クラスの新しいインスタンスを初期化します。
   * 
   * @param value 作成日時の値。
   * @throws DiaryValidationException 作成日時が不正な場合。
   */
  public CreatedDate(LocalDate value) throws DiaryValidationException {
    if (value == null) {
      throw new DiaryValidationException(
          ExceptionIdConstants.E_DIARY_FIELD_IS_REQUIRED,
          new String[] { String.valueOf("作成日時") },
          new String[] { String.valueOf("作成日時") });
    }
    this.value = value;
  }
}
