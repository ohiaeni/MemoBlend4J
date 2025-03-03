package com.memoblend.web.controller.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザー情報の取得レスポンスクラスです。
 */
@Data
@AllArgsConstructor
public class GetUserResponse {
  private long id;
  private String name;
  private boolean isDeleted;
}
