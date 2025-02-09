package com.memoblend.applicationcore.user;

import com.memoblend.applicationcore.constant.ExceptionIdConstants;
import com.memoblend.systemcommon.exception.LogicException;

/**
 * ユーザーが既に存在する場合の例外です。
 */
public class UserAlreadyExistException extends LogicException {
  /**
   * {@link UserAlreadyExistException} クラスのインスタンスを初期化します。
   * 
   * @param id ID。
   */
  public UserAlreadyExistException(long id) {
    super(null, ExceptionIdConstants.E_USER_ALREADY_EXIST,
        new String[] { String.valueOf(id) },
        new String[] { String.valueOf(id) });
  }
}