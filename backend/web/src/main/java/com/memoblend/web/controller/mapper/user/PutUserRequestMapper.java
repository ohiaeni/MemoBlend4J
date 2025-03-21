package com.memoblend.web.controller.mapper.user;

import com.memoblend.applicationcore.user.User;
import com.memoblend.web.controller.dto.user.PutUserRequest;

/**
 * {@link PutUserRequest} から {@link User} への変換を行うクラスです。
 */
public class PutUserRequestMapper {

  /**
   * {@link PutUserRequest} から {@link User} へ変換します。
   * 
   * @param request ユーザーの更新リクエスト。
   * @return ユーザー。
   */
  public static User convert(PutUserRequest request) {
    User user = new User(
        request.getId(),
        request.getName(),
        false);
    return user;
  }
}
