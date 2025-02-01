package com.memoblend.web.controller.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザーの更新リクエストクラスです。
 */
@Data
@AllArgsConstructor
public class PutUserRequest {
  private long id;
  private String userName;
}
