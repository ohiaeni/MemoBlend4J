package com.memoblend.web.controller.mapper.user;

import com.memoblend.applicationcore.user.User;
import com.memoblend.web.controller.dto.user.PutUserRequest;
import com.memoblend.applicationcore.user.valueobject.Id;
import com.memoblend.applicationcore.user.valueobject.Name;
import com.memoblend.applicationcore.user.valueobject.IsDeleted;

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
    Id id = new Id(request.getId());
    Name name = new Name(request.getName());
    IsDeleted isDeleted = new IsDeleted(false);
    User user = new User(
        id,
        name,
        isDeleted);
    return user;
  }
}
