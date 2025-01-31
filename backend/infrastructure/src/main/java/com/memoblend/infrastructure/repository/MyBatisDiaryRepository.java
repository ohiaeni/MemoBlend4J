package com.memoblend.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.applicationcore.diary.DiaryRepository;
import com.memoblend.infrastructure.repository.mapper.DiaryMapper;
import lombok.AllArgsConstructor;

/**
 * 日記のリポジトリです。
 */
@Repository
@AllArgsConstructor
public class MyBatisDiaryRepository implements DiaryRepository {

  @Autowired
  private DiaryMapper diaryMapper;

  @Override
  public List<Diary> findAll() {
    return diaryMapper.findAll();
  }

  @Override
  public Diary findByDate(LocalDate date) {
    return diaryMapper.findByDate(date);
  }

  @Override
  public Diary add(Diary diary) {
    Diary addedDiary = new Diary(0, diary.getUserId(), diary.getTitle(), diary.getContent(), diary.getDate());
    diaryMapper.add(addedDiary);
    diary.setId(addedDiary.getUserId());
    return addedDiary;
  }

  @Override
  public long delete(long id) {
    return diaryMapper.delete(id);
  }

  @Override
  public long update(Diary diary) {
    return diaryMapper.update(diary);
  }
}
