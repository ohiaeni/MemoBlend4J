package com.memoblend.applicationcore.applicationservice;

import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import com.memoblend.applicationcore.constant.MessageIdConstants;
import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.applicationcore.diary.DiaryAlreadyExistException;
import com.memoblend.applicationcore.diary.DiaryDomainService;
import com.memoblend.applicationcore.diary.DiaryNotFoundException;
import com.memoblend.applicationcore.diary.DiaryRepository;
import com.memoblend.systemcommon.constant.SystemPropertyConstants;
import lombok.AllArgsConstructor;

/**
 * 日記のアプリケーションサービスです。
 */
@Service
@AllArgsConstructor
public class DiaryApplicationService {

  @Autowired
  private DiaryRepository diaryRepository;
  @Autowired
  private DiaryDomainService diaryDomainService;
  private MessageSource messages;
  private final Logger apLog = Logger.getLogger(SystemPropertyConstants.APPLICATION_LOGGER);

  /**
   * 全ての日記を取得します。
   * 
   * @return 全ての日記。
   */
  public List<Diary> getDiaries() {
    apLog.info(messages.getMessage(MessageIdConstants.D_DIARY_GET_DIARIES, new Object[] {}, Locale.getDefault()));
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
    apLog.info(messages.getMessage(MessageIdConstants.D_DIARY_GET_DIARY,
        new Object[] { date.getYear(), date.getMonthValue(), date.getDayOfMonth() }, Locale.getDefault()));
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
   * @throws DiaryAlreadyExistException 日記が既に存在する場合。
   */
  public Diary addDiary(Diary diary) throws DiaryAlreadyExistException {
    final LocalDate date = diary.getDate();
    apLog.info(messages.getMessage(MessageIdConstants.D_DIARY_ADD_DIARY,
        new Object[] { date.getYear(), date.getMonthValue(), date.getDayOfMonth() }, Locale.getDefault()));
    if (diaryDomainService.isExistDiary(diary)) {
      throw new DiaryAlreadyExistException(date);
    }
    Diary addedDiary = diaryRepository.add(diary);
    return addedDiary;
  }

  /**
   * 日記を更新します。
   * 
   * @param diary 更新する日記。
   */
  public void updateDiary(Diary diary) {
    final LocalDate date = diary.getDate();
    apLog.info(date.getYear() + "年" + date.getMonthValue() + "月" + date.getDayOfMonth() + "日の日記を更新します。");
    diaryRepository.update(diary);
  }

  /**
   * 日記を削除します。
   * 
   * @param date 日記を作成した日付。
   * @param id   日記のID。
   */
  public void deleteDiary(LocalDate date, long id) {
    apLog.info(date.getYear() + "年" + date.getMonthValue() + "月" + date.getDayOfMonth() + "日の日記を削除します。");
    diaryRepository.delete(id);
  }
}
