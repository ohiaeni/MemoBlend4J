package com.memoblend.web.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.memoblend.applicationcore.applicationservice.UserApplicationService;
import com.memoblend.applicationcore.user.UserNotFoundException;
import com.memoblend.applicationcore.user.User;
import com.memoblend.systemcommon.constant.CommonExceptionIdConstants;
import com.memoblend.systemcommon.constant.SystemPropertyConstants;
import com.memoblend.web.controller.dto.user.GetUserResponse;
import com.memoblend.web.controller.dto.user.PostUserRequest;
import com.memoblend.web.controller.dto.user.PutUserRequest;
import com.memoblend.web.controller.mapper.user.GetUserReponseMapper;
import com.memoblend.web.controller.mapper.user.PostUserRequestMapper;
import com.memoblend.web.controller.mapper.user.PutUserRequestMapper;
import com.memoblend.web.controller.util.ProblemDetailsFactory;
import com.memoblend.web.log.ErrorMessageBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

/**
 * ユーザー情報の操作を行うコントローラークラスです。
 */
@RestController
@RequestMapping("api/user")
@Tag(name = "User", description = "ユーザーの情報にアクセスする API です。")
@AllArgsConstructor
public class UserController {
  @Autowired
  UserApplicationService userApplicationService;
  @Autowired
  private ProblemDetailsFactory problemDetailsFactory;
  private static final Logger apLog = LoggerFactory.getLogger(SystemPropertyConstants.APPLICATION_LOGGER);

  /**
   * ID を指定して、ユーザー情報を取得します。
   * 
   * @param id ユーザー ID 。
   * @return ユーザー情報。
   */
  @Operation(summary = "ID を指定して、ユーザー情報を取得します。", description = "ID を指定して、ユーザー情報を取得します。")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "成功。", content = @Content),
      @ApiResponse(responseCode = "400", description = "リクエストエラー。", content = @Content),
      @ApiResponse(responseCode = "404", description = "対応したユーザーが存在しません。", content = @Content),
      @ApiResponse(responseCode = "500", description = "サーバーエラー。", content = @Content)
  })
  @GetMapping("{id}")
  public ResponseEntity<?> getUser(@PathVariable("id") long id) {
    User user = null;
    try {
      user = userApplicationService.getUser(id);
    } catch (UserNotFoundException e) {
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
    GetUserResponse response = GetUserReponseMapper.convert(user);
    return ResponseEntity.ok().body(response);
  }

  /**
   * ユーザー情報を登録します。
   * 
   * @param request ユーザー情報。
   * @return 登録結果。
   */
  @Operation(summary = "ユーザー情報を登録します。", description = "ユーザー情報を登録します。")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "成功。", content = @Content),
      @ApiResponse(responseCode = "400", description = "リクエストエラー。", content = @Content),
      @ApiResponse(responseCode = "500", description = "サーバーエラー。", content = @Content)
  })
  @PostMapping
  public ResponseEntity<?> postUser(@RequestBody PostUserRequest request) {
    User user = PostUserRequestMapper.convert(request);
    User addedUser = userApplicationService.addUser(user);
    return ResponseEntity.created(URI.create("/api/user/" + addedUser.getId())).build();
  }

  /**
   * ID を指定して、ユーザー情報を削除します。
   * 
   * @param id ユーザーの ID 。
   * @return 削除結果。
   */
  @Operation(summary = "ID を指定して、ユーザー情報を削除します。", description = "ID を指定して、ユーザー情報を削除します。")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "成功。", content = @Content),
      @ApiResponse(responseCode = "400", description = "リクエストエラー。", content = @Content),
      @ApiResponse(responseCode = "404", description = "対応したユーザーが存在しません。", content = @Content),
      @ApiResponse(responseCode = "500", description = "サーバーエラー。", content = @Content),
  })
  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
    try {
      userApplicationService.deleteUser(id);
    } catch (UserNotFoundException e) {
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
    return ResponseEntity.ok().build();
  }

  /**
   * ユーザー情報を更新します。
   * 
   * @param request ユーザー情報。
   * @return 更新結果。
   */
  @Operation(summary = "ユーザー情報を更新します。", description = "ユーザー情報を更新します。")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "成功。", content = @Content),
      @ApiResponse(responseCode = "400", description = "リクエストエラー。", content = @Content),
      @ApiResponse(responseCode = "404", description = "対応したユーザーが存在しません。", content = @Content),
      @ApiResponse(responseCode = "500", description = "サーバーエラー。", content = @Content),
  })
  @PutMapping
  public ResponseEntity<?> putUser(@RequestBody PutUserRequest request) {
    User user = PutUserRequestMapper.convert(request);
    try {
      userApplicationService.updateUser(user);
    } catch (UserNotFoundException e) {
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
    return ResponseEntity.ok().build();
  }
}
