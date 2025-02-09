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
   * @return 全ての日記のリスト。
   */
  public List<Diary> getDiaries() {
    apLog.info(messages.getMessage(MessageIdConstants.D_DIARY_GET_DIARIES, new Object[] {}, Locale.getDefault()));
    return diaryRepository.findAll();
  }

  /**
   * ID を指定して、{@link Diary} を取得します。
   * 
   * @param id 日記の ID 。
   * @return 条件に合う日記。
   * @throws DiaryNotFoundException 日記が見つからない場合。
   */
  public Diary getDiary(long id) throws DiaryNotFoundException {
    apLog.info(messages.getMessage(MessageIdConstants.D_DIARY_GET_DIARY,
        new Object[] { id }, Locale.getDefault()));
    Diary diary = diaryRepository.findById(id);
    if (diary == null) {
      throw new DiaryNotFoundException(id);
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
    final LocalDate date = diary.getDate();
    apLog.info(messages.getMessage(MessageIdConstants.D_DIARY_ADD_DIARY,
        new Object[] { date.getYear(), date.getMonthValue(), date.getDayOfMonth() }, Locale.getDefault()));
    Diary addedDiary = diaryRepository.add(diary);
    return addedDiary;
  }

  /**
   * 日記を更新します。
   * 
   * @param diary 更新する日記。
   * @throws DiaryNotFoundException 日記が見つからない場合。
   */
  public void updateDiary(Diary diary) throws DiaryNotFoundException {
    final long id = diary.getId();
    apLog.info(messages.getMessage(MessageIdConstants.D_DIARY_UPDATE_DIARY,
        new Object[] { id }, Locale.getDefault()));
    if (!diaryDomainService.isExistDiary(id)) {
      throw new DiaryNotFoundException(id);
    }
    diaryRepository.update(diary);
  }

  /**
   * 日記を削除します。
   * 
   * @param id 日記のID。
   * @throws DiaryNotFoundException 日記が見つからない場合。
   */
  public void deleteDiary(long id) throws DiaryNotFoundException {
    apLog.info(messages.getMessage(MessageIdConstants.D_DIARY_DELETE_DIARY,
        new Object[] { id }, Locale.getDefault()));
    if (!diaryDomainService.isExistDiary(id)) {
      throw new DiaryNotFoundException(id);
    }
    diaryRepository.delete(id);
  }
}
