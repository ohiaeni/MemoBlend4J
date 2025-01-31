package com.memoblend.applicationcore.user;

import com.memoblend.systemcommon.exception.LogicException;

/**
 * ユーザーが見つからない場合の例外です。
 */
public class UserNotFoundException extends LogicException {
  /**
   * {@link UserNotFoundException} クラスのインスタンスを初期化します。
   * 
   * @param userId ユーザーID。
   */
  public UserNotFoundException(long userId) {
    super(null, "ユーザーIDが、" + userId + "のユーザーは存在しません", null, null);
  }
}
