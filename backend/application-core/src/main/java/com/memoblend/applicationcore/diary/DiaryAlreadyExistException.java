package com.memoblend.applicationcore.diary;

import java.time.LocalDate;
import com.memoblend.applicationcore.constant.ExceptionIdConstants;
import com.memoblend.systemcommon.exception.LogicException;

/**
 * 日記が既に存在する場合の例外です。
 */
public class DiaryAlreadyExistException extends LogicException {
  /**
   * {@link DiaryAlreadyExistException} クラスのインスタンスを初期化します。
   * 
   * @param date 日記を作成した日付。
   */
  public DiaryAlreadyExistException(LocalDate date) {
    super(null, ExceptionIdConstants.E_DIARY_ALREADY_EXIST,
        new String[] { String.valueOf(date.getYear()), String.valueOf(date.getMonthValue()),
            String.valueOf(date.getDayOfMonth()) },
        new String[] { String.valueOf(date.getYear()), String.valueOf(date.getMonthValue()),
            String.valueOf(date.getDayOfMonth()) });
  }
}
