package com.memoblend.applicationcore.applicationservice;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.applicationcore.diary.DiaryRepository;

/**
 * 日記のサービスです。
 */
public class DiaryApplicationService {
    @Autowired
    private DiaryRepository diaryRepository;
    public Diary GetDiary(LocalDate date) {
        Diary diary = diaryRepository.findByDate(date);
        return diary;
    }
}
