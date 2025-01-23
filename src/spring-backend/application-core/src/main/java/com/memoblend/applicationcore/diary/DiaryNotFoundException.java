package com.memoblend.applicationcore.diary;

import java.time.LocalDate;
import com.memoblend.systemcommon.exception.LogicException;

/**
 * 日記が見つからない場合の例外です。
 */
public class DiaryNotFoundException extends LogicException {

  /**
   * {@link DiaryNotFoundException} クラスのインスタンスを初期化します。
   * 
   * @param date 日記を作成した日付。
   */
  public DiaryNotFoundException(LocalDate date) {
    super(null, date.getYear() + "年" + date.getMonth() + "月" + date.getDayOfMonth() + "日の日記は存在しません", null, null);
  }
}
