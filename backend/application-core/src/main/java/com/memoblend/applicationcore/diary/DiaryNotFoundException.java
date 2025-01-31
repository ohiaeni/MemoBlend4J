package com.memoblend.applicationcore.diary;

import java.time.LocalDate;
import com.memoblend.applicationcore.constant.ExceptionIdConstants;
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
    super(null, ExceptionIdConstants.E_DIARY_NOT_FOUND,
        new String[] { String.valueOf(date.getYear()), String.valueOf(date.getMonthValue()),
            String.valueOf(date.getDayOfMonth()) },
        new String[] { String.valueOf(date.getYear()), String.valueOf(date.getMonthValue()),
            String.valueOf(date.getDayOfMonth()) });
  }
}
