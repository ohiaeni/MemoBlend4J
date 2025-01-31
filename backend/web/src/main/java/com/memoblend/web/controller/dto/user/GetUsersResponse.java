package com.memoblend.web.controller.dto.user;

import java.util.List;
import com.memoblend.applicationcore.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザーのリスト取得レスポンスクラスです。
 */
@AllArgsConstructor
@Data
public class GetUsersResponse {
  private List<User> users;
}
