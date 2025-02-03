package com.memoblend.applicationcore.user;

import com.memoblend.systemcommon.exception.LogicException;

/**
 * ユーザーが見つからない場合の例外です。
 */
public class UserNotFoundException extends LogicException {
  /**
   * {@link UserNotFoundException} クラスのインスタンスを初期化します。
   * 
   * @param id ユーザーID。
   */
  public UserNotFoundException(long id) {
    super(null, "ユーザーIDが、" + id + "のユーザーは存在しません", null, null);
  }
}
