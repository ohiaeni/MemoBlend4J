package com.memoblend.infrastructure.repository;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.applicationcore.diary.DiaryRepository;
import com.memoblend.infrastructure.repository.mapper.DiaryMapper;

/**
 * 日記のリポジトリです。
 */
public class MyBatisDiaryRepository implements DiaryRepository {

  @Autowired
  private DiaryMapper diaryMapper;

  @Override
  public Optional<Diary> findByDate(LocalDate date) {
    return Optional.of(diaryMapper.findByDate(date));
  }

  @Override
  public void add(Diary diary) {
    diaryMapper.add(diary);
  }
}
