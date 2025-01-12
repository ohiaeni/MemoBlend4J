package com.memoblend.web.controller.dto.util;

import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.web.controller.dto.diary.GetDiaryResponse;
import com.memoblend.web.controller.dto.diary.PostDiaryRequest;

public class DataTransferObjectConverter {
  /**
   * 日記オブジェクトから各属性を取り出し、DTOとして返します。
   * 
   * @param diary 日記オブジェクト
   * @return DTOとしての日記情報
   */
  public static GetDiaryResponse diaryConverter(Diary diary) {
    return new GetDiaryResponse(
      diary.getDate(), 
      diary.getDiaryId(), 
      diary.getTitle(), 
      diary.getContent(), 
      diary.getUserId());
  }

  /**
   * Postから日記オブジェクトを作成し、返します。
   * 
   * @param request 日記情報
   * @return 日記オブジェクト
   */
  public static Diary diaryConverter(PostDiaryRequest response) {
    return new Diary(
      response.getDate(), 
      response.getDiaryId(), 
      response.getTitle(), 
      response.getContent(), 
      response.getUserId());
  } 
}
