package com.memoblend.applicationcore.applicationservice;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.applicationcore.diary.DiaryRepository;
import lombok.AllArgsConstructor;

/**
 * 日記のサービスです。
 */
@Service
@AllArgsConstructor
public class DiaryApplicationService {
  
  @Autowired
  private DiaryRepository diaryRepository;
  
  public Diary GetDiary(LocalDate date) {
    Optional<Diary> diary = diaryRepository.findByDate(date);
    return diary.get();
  }

  public Diary AddDiary(Diary diary) {
    Diary addedDiary = diaryRepository.add(diary);
    return addedDiary;
  }
}
