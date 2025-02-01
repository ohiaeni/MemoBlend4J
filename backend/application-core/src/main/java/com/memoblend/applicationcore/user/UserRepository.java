package com.memoblend.applicationcore.user;

import java.util.List;

/**
 * ユーザーのリポジトリのインターフェースです。
 */
public interface UserRepository {
  /**
   * 全てのユーザーを取得します。
   * 
   * @return 全てのユーザー。
   */
  List<User> findAll();

  /**
   * ID を指定して、 {@link User} を取得します。
   * 
   * @param id 日記を作成した日付。
   * @return 条件に合う日記。
   */
  User findById(long id);

  /**
   * ユーザーを追加します。
   * 
   * @param user 追加するユーザー。
   */
  User add(User user);

  /**
   * ID を指定して、 {@link User} を削除します。
   * 
   * @param id 削除するユーザーの ID。
   */
  long delete(long id);

  /**
   * {@link User} を更新します。
   * 
   * @param user 更新するユーザー。
   */
  long update(User user);
}
