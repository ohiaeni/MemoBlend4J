package com.memoblend.web.controller.mapper.user;

import com.memoblend.applicationcore.user.User;
import com.memoblend.web.controller.dto.user.PostUserRequest;

/**
 * {@link PostUserRequest} を {@link User} に変換するクラスです。
 */
public class PostUserRequestMapper {

  /**
   * {@link PostUserRequest} を {@link User} に変換します。
   * 
   * @param request リクエスト。
   * @return ユーザー。
   */
  public static User convert(PostUserRequest request) {
    User user = new User(
        0,
        request.getName(),
        false);
    return user;
  }
}
