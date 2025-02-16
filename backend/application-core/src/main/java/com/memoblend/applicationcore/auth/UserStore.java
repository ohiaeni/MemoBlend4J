package com.memoblend.applicationcore.auth;

import java.util.List;

/**
 * ログインしているユーザーの情報を保持するためのインターフェースです。
 */
public interface UserStore {

  /**
   * ログインしているユーザーのユーザー名を取得します。
   */
  public String getLoginUserName();

  /**
   * ログインしているユーザーのロール名を取得します。
   */
  public List<String> getLoginUserRoles();

  /**
   * ログインしているユーザーが指定されたロールに所属しているかどうかを判定します。
   */
  public boolean isInRole(String role);
}
