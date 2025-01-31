package com.memoblend.web.controller;

import org.springframework.web.bind.annotation.RestController;
import com.memoblend.applicationcore.applicationservice.DiaryApplicationService;
import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.applicationcore.diary.DiaryNotFoundException;
import com.memoblend.systemcommon.constant.CommonExceptionIdConstants;
import com.memoblend.systemcommon.constant.SystemPropertyConstants;
import com.memoblend.systemcommon.util.LocalDateConverter;
import com.memoblend.web.controller.dto.diary.GetDiariesResponse;
import com.memoblend.web.controller.dto.diary.GetDiaryResponse;
import com.memoblend.web.controller.dto.diary.PostDiaryRequest;
import com.memoblend.web.controller.dto.mapper.GetDiariesResponseMapper;
import com.memoblend.web.controller.dto.mapper.GetDiaryReponseMapper;
import com.memoblend.web.controller.dto.mapper.PostDiaryRequestMapper;
import com.memoblend.web.log.ErrorMessageBuilder;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
  @Autowired
  DiaryApplicationService diaryApplicationService;
  @Autowired
  private ProblemDetailsFactory problemDetailsFactory;

  private static final Logger apLog = LoggerFactory.getLogger(SystemPropertyConstants.APPLICATION_LOGGER);

  /**
   * 日記を全件取得します。
   * 
   * @return 日記情報。
   */
  @GetMapping("")
  public ResponseEntity<GetDiariesResponse> getDiaries() {
    List<Diary> diaries = diaryApplicationService.getDiaries();
    GetDiariesResponse response = GetDiariesResponseMapper.convert(diaries);
    return ResponseEntity.ok().body(response);
  }

  /**
   * 日記情報を取得します。
   * 
   * @param date 日記の日付
   * @return 日記情報
   */
  @GetMapping("{date}")
  public ResponseEntity<?> getDiary(@PathVariable("date") long date) {
    LocalDate convertedDate = LocalDateConverter.longToLocalDate(date);
    Diary diary = null;
    try {
      diary = diaryApplicationService.getDiary(convertedDate);
    } catch (DiaryNotFoundException e) {
      apLog.info(e.getMessage());
      apLog.debug(ExceptionUtils.getStackTrace(e));
      ErrorMessageBuilder errorBuilder = new ErrorMessageBuilder(e, e.getExceptionId(),
          e.getLogMessageValue(), e.getFrontMessageValue());
      ProblemDetail problemDetail = problemDetailsFactory.createProblemDetail(errorBuilder,
          CommonExceptionIdConstants.E_BUSINESS, HttpStatus.NOT_FOUND);
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .contentType(MediaType.APPLICATION_PROBLEM_JSON)
          .body(problemDetail);
    }
    GetDiaryResponse response = GetDiaryReponseMapper.convert(diary);
    return ResponseEntity.ok().body(response);
  }

  /**
   * 日記情報を登録します。
   * 
   * @param request 日記情報。
   * @return 登録結果。
   */
  @PostMapping
  public ResponseEntity<?> postDiary(@RequestBody PostDiaryRequest request) {
    Diary diary = PostDiaryRequestMapper.convert(request);
    Diary addedDiary = diaryApplicationService.addDiary(diary);
    return ResponseEntity.created(URI.create("/api/diary/" + addedDiary.getDate())).build();
  }

  /**
   * 日記情報を削除します。
   * 
   * @param date 日記の日付。
   * @return 削除結果。
   */
  @DeleteMapping("{date}")
  public ResponseEntity<?> deleteDiary(@PathVariable("date") long date) {
    LocalDate convertedDate = LocalDateConverter.longToLocalDate(date);
    Diary diary = null;
    try {
      diary = diaryApplicationService.getDiary(convertedDate);
    } catch (DiaryNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
    diaryApplicationService.deleteDiary(diary.getDate(), diary.getId());
    return ResponseEntity.ok().build();
  }
}
