package com.memoblend.web.controller.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザーの登録リクエストクラスです。
 */
@Data
@AllArgsConstructor
public class PostUserRequest {
  private long id;
  private String userName;
}
