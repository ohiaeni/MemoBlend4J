package com.memoblend.web.controller.mapper.diary;

import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.web.controller.dto.diary.PostDiaryRequest;

/**
 * {@link PostDiaryRequest} を {@link Diary} に変換するクラスです。
 */
public class PostDiaryRequestMapper {

  /**
   * {@link PostDiaryRequest} を {@link Diary} に変換します。
   * 
   * @param request リクエスト。
   * @return 日記。
   */
  public static Diary convert(PostDiaryRequest request) {
    Diary diary = new Diary(
        0,
        request.getUserId(),
        request.getTitle(),
        request.getContent(),
        request.getDate(),
        false);
    return diary;
  }
}
