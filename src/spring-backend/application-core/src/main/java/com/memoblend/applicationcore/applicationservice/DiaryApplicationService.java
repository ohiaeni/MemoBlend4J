package com.memoblend.applicationcore.applicationservice;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.applicationcore.diary.DiaryNotFoundException;
import com.memoblend.applicationcore.diary.DiaryRepository;
import lombok.AllArgsConstructor;

/**
 * 日記のアプリケーションサービスです。
 */
@Service
@AllArgsConstructor
public class DiaryApplicationService {

  @Autowired
  private DiaryRepository diaryRepository;

  /**
   * 全ての日記を取得します。
   * 
   * @return 全ての日記。
   */
  public List<Diary> getDiaries() {
    return diaryRepository.findAll();
  }

  /**
   * 日付を指定して、
   * {@link Diary} を取得します。
   * 
   * @param date 日記を作成した日付。
   * @return 条件に合う日記。
   * @throws DiaryNotFoundException 日記が見つからない場合。
   */
  public Diary getDiary(LocalDate date) throws DiaryNotFoundException {
    Diary diary = diaryRepository.findByDate(date);
    if (diary == null) {
      throw new DiaryNotFoundException(date);
    }
    return diary;
  }

  /**
   * 日記を追加します。
   * 
   * @param diary 追加する日記。
   * @return 追加された日記。
   */
  public Diary addDiary(Diary diary) {
    Diary addedDiary = diaryRepository.add(diary);
    return addedDiary;
  }
}
