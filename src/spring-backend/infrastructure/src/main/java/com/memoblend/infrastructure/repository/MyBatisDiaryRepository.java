package com.memoblend.infrastructure.repository;

import java.time.LocalDate;
import java.util.Optional;
import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.applicationcore.diary.DiaryRepository;

/**
 * 日記のリポジトリです。
 */
public class MyBatisDiaryRepository implements DiaryRepository {

  @Override
  public Optional<Diary> findByDate(LocalDate date) {
    throw new UnsupportedOperationException("Unimplemented method 'findByDate'");
  }

  @Override
  public void add(Diary diary) {
    throw new UnsupportedOperationException("Unimplemented method 'add'");
  }

}
