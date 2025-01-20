package com.memoblend.applicationcore.diary;

import java.time.LocalDate;
import java.util.Optional;

/**
 * 日記のリポジトリのインターフェースです。
 */
public interface DiaryRepository {
  /**
   * ID を指定して、
   * {@link Diary} を取得します。
   * 
   * @param date 日記を作成した日付。
   * @return 条件に合う日記。
   */
  Optional<Diary> findByDate(LocalDate date);

  /**
   * 日記を追加します。
   * 
   * @param diary 追加する日記。
   */
  Diary add(Diary diary);
}
