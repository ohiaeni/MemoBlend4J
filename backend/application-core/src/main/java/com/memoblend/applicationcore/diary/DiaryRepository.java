package com.memoblend.applicationcore.diary;

import java.time.LocalDate;
import java.util.List;

/**
 * 日記のリポジトリのインターフェースです。
 */
public interface DiaryRepository {

  /**
   * 全ての日記を取得します。
   * 
   * @return 全ての日記。
   */
  List<Diary> findAll();

  /**
   * ID を指定して、 {@link Diary} を取得します。
   * 
   * @param date 日記を作成した日付。
   * @return 条件に合う日記。
   */
  Diary findByDate(LocalDate date);

  /**
   * 日記を追加します。
   * 
   * @param diary 追加する日記。
   */
  Diary add(Diary diary);

  /**
   * ID を指定して、 {@link Diary} を削除します。
   * 
   * @param id 削除する日記の ID。
   */
  long delete(long id);

  /**
   * {@link Diary} を更新します。
   * 
   * @param diary 更新する日記。
   */
  long update(Diary diary);
}
