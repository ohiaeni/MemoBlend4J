package com.memoblend.web.controller.dto.mapper;

import java.util.List;
import com.memoblend.applicationcore.user.User;
import com.memoblend.web.controller.dto.user.GetUsersResponse;

/**
 * {@link User} のリストを {@link GetUsersResponse} に変換するクラスです。
 */
public class GetUsersResponseMapper {
  /**
   * {@link User} のリストを {@link GetUsersResponse} に変換します。
   * 
   * @param users ユーザーのリスト。
   * @return {@link GetUsersResponse} のインスタンス。
   */
  public static GetUsersResponse convert(List<User> users) {
    GetUsersResponse response = new GetUsersResponse(users);
    return response;
  }
}
