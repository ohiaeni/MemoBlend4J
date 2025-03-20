package com.memoblend.applicationcore.diary.valueobject;

import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 作成日時を表す値オブジェクト。
 */
@Getter
@EqualsAndHashCode
public class CreatedDate {
  private final LocalDate value;

  /**
   * {@link CreatedDate} クラスの新しいインスタンスを初期化します。
   * 
   * @param value 作成日時の値。
   * @throws IllegalArgumentException 作成日時の値が null の場合。
   */
  public CreatedDate(LocalDate value) {
    if (value == null) {
      throw new IllegalArgumentException("{0} は必須です");
    }
    this.value = value;
  }
}
