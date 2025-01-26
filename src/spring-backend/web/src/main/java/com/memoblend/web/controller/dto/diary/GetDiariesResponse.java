package com.memoblend.web.controller.dto.diary;

import java.util.List;
import com.memoblend.applicationcore.diary.Diary;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 日記のリスト取得レスポンスクラスです。
 */
@AllArgsConstructor
@Data
public class GetDiariesResponse {
  private List<Diary> diaries;
}
