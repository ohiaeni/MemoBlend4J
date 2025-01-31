package com.memoblend.web.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.memoblend.systemcommon.constant.LoggerConstant;
import com.memoblend.systemcommon.exception.LogicException;
import com.memoblend.systemcommon.exception.SystemException;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 開発環境とテスト環境で使用する集約例外ハンドラークラスです。
 */
@ControllerAdvice(basePackages = "com.memoblend")
@Profile("local | test")
public class LocalExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {

  private static final Logger apLog = LoggerFactory.getLogger(LoggerConstant.APPLICATION_LOGGER);

  /**
   * その他の業務エラーをステータースコード 500 で返却します。
   *
   * @param e   業務例外。
   * @param req リクエスト。
   * @return ステータースコード 500 のレスポンス。
   */
  @ExceptionHandler(LogicException.class)
  public ResponseEntity<ProblemDetail> handleLogicException(LogicException e, HttpServletRequest req) {
    apLog.error(e.getMessage(), e);
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .contentType(MediaType.APPLICATION_PROBLEM_JSON)
        .body(problemDetail);
  }

  /**
   * その他のシステムエラーをステータースコード 500 で返却します。
   *
   * @param e   その他の例外。
   * @param req リクエスト。
   * @return ステータースコード 500 のレスポンス。
   */
  @ExceptionHandler(SystemException.class)
  public ResponseEntity<ProblemDetail> handleSystemException(SystemException e, HttpServletRequest req) {
    apLog.error(e.getMessage(), e);
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .contentType(MediaType.APPLICATION_PROBLEM_JSON)
        .body(problemDetail);
  }

  /**
   * 上記のいずれにも当てはまらない例外をステータースコード 500 で返却します。
   *
   * @param e   その他の例外。
   * @param req リクエスト。
   * @return ステータースコード 500 のレスポンス。
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ProblemDetail> handleException(Exception e, HttpServletRequest req) {
    apLog.error(e.getMessage(), e);
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .contentType(MediaType.APPLICATION_PROBLEM_JSON)
        .body(problemDetail);
  }
}
