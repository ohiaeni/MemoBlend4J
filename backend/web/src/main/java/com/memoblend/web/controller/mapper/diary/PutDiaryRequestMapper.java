package com.memoblend.web.controller.mapper.diary;

import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.web.controller.dto.diary.PutDiaryRequest;

/**
 * {@link PutDiaryRequest} から {@link Diary} への変換を行うクラスです。
 */
public class PutDiaryRequestMapper {

  /**
   * {@link PutDiaryRequest} から {@link Diary} へ変換します。
   * 
   * @param request 日記の更新リクエスト。
   * @return 日記。
   */
  public static Diary convert(PutDiaryRequest request) {
    Diary diary = new Diary(
        request.getId(),
        request.getUserId(),
        request.getTitle(),
        request.getContent(),
        request.getDate());
    return diary;
  }
}
