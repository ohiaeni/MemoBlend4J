package com.memoblend.web.controller.dto.mapper;

import com.memoblend.applicationcore.user.User;
import com.memoblend.web.controller.dto.user.GetUserResponse;

/**
 * {@link User} を {@link GetUserResponse} に変換するクラスです。
 */
public class GetUserReponseMapper {

  /**
   * {@link User} を {@link GetUserResponse} に変換します。
   * 
   * @param user ユーザー。
   * @return {@link GetUserResponse} のインスタンス。
   */
  public static GetUserResponse convert(User user) {
    GetUserResponse response = new GetUserResponse(
        user.getId(),
        user.getUserName());
    return response;
  }
}
