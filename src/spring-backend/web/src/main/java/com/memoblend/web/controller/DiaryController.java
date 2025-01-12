package com.memoblend.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.memoblend.applicationcore.applicationservice.DiaryApplicationService;
import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.applicationcore.diary.DiaryRepository;
import com.memoblend.systemcommon.util.LocalDateConverter;
import com.memoblend.web.controller.dto.diary.GetDiaryResponse;
import com.memoblend.web.controller.dto.diary.PostDiaryRequest;
import com.memoblend.web.controller.dto.util.DataTransferObjectConverter;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import java.net.URI;
import java.time.LocalDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 日記情報の操作を行うコントローラークラスです。
 */
@RestController
@RequestMapping("api/diary")
@Tag(name = "Diary", description = "日記の情報にアクセスするAPI")
@AllArgsConstructor
public class DiaryController {
  DiaryApplicationService diaryApplicationService;

  /**
   * 日記情報を取得します。
   * 
   * @param date 日記の日付
   * @return 日記情報
   */
  @GetMapping("{date}")
  public ResponseEntity<GetDiaryResponse> getDiary(@PathVariable("date") long date) {
    LocalDate convertedDate = LocalDateConverter.longToLocalDate(date);
    Diary diary = diaryApplicationService.GetDiary(convertedDate);
    GetDiaryResponse response = DataTransferObjectConverter.DiaryConverter(diary);
    return ResponseEntity.ok().body(response);
  }

  /**
   * 日記情報を登録します。
   * 
   * @param request 日記情報
   * @return 登録結果
   */
  @PostMapping
  public ResponseEntity<?> postDiary(@RequestBody PostDiaryRequest request) {
    Diary addedDiary = new Diary(request.getDate(), request.getTitle(), request.getContent());
    diaryRepository.register(addedDiary);
    return ResponseEntity.created(URI.create("/api/diary/" + addedDiary.getDate())).build();
  }
}
