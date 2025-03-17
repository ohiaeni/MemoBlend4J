package com.memoblend.web.controller.mapper.user;

import com.memoblend.applicationcore.user.User;
import com.memoblend.web.controller.dto.user.PostUserRequest;
import com.memoblend.applicationcore.user.valueobject.Id;
import com.memoblend.applicationcore.user.valueobject.Name;
import com.memoblend.applicationcore.user.valueobject.IsDeleted;

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
    Id id = new Id(0);
    Name name = new Name(request.getName());
    IsDeleted isDeleted = new IsDeleted(false);
    User user = new User(
        id,
        name,
        isDeleted);
    return user;
  }
}
