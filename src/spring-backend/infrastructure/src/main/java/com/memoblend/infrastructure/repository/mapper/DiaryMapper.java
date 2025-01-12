package com.memoblend.infrastructure.repository.mapper;

import java.time.LocalDate;
import org.apache.ibatis.annotations.Mapper;
import com.memoblend.applicationcore.diary.Diary;

/**
 * 日記のマッパーです。
 */
@Mapper
public interface DiaryMapper {
    /**
     * 日付を指定して、
     * {@link Diary} を取得します。
     * 
     * @param date 日記を作成した日付。
     * @return 条件に合う日記。
     */
    public Diary findByDate(LocalDate date);

    /**
     * 日記を追加します。
     * 
     * @param diary 追加する日記。
     */
    public void add(Diary diary);
}
