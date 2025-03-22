package com.memoblend.applicationcore.user;

import org.springframework.lang.NonNull;
import com.memoblend.applicationcore.user.valueobject.Id;
import com.memoblend.applicationcore.user.valueobject.IsDeleted;
import com.memoblend.applicationcore.user.valueobject.Name;

/**
 * ユーザーのドメインモデルです。
 */
public class User {

  @NonNull
  private Id id;
  @NonNull
  private Name name;
  @NonNull
  private IsDeleted isDeleted;

  /**
   * ユーザーオブジェクトを生成します。
   *
   * @param id        ユーザーの ID 。
   * @param name      ユーザーの名前。
   * @param isDeleted 削除済みの場合 true 、 未削除の場合 false 。
   * @throws UserValidationException ユーザーが不正な場合。
   */
  public User(long id, String name, boolean isDeleted) throws UserValidationException {
    this.id = new Id(id);
    this.name = new Name(name);
    this.isDeleted = new IsDeleted(isDeleted);
  }

  /**
   * ユーザーのIDを取得します。
   *
   * @return ユーザーの ID 。
   */
  public long getId() {
    return this.id.getValue();
  }

  /**
   * ユーザーの名前を取得します。
   *
   * @return ユーザーの名前。
   */
  public String getName() {
    return this.name.getValue();
  }

  /**
   * ユーザーの削除状態を取得します。
   *
   * @return 削除済みの場合 true 、 未削除の場合 false 。
   */
  public boolean getIsDeleted() {
    return this.isDeleted.isValue();
  }

  /**
   * ユーザーのIDを設定します。
   *
   * @param id 新しいユーザー ID 。
   */
  public void setId(long id) {
    this.id = new Id(id);
  }

  /**
   * ユーザーの名前を設定します。
   *
   * @param name 新しいユーザー名。
   * @throws UserValidationException ユーザー名が不正な場合。
   */
  public void setName(String name) throws UserValidationException {
    this.name = new Name(name);
  }

  /**
   * ユーザーの削除状態を設定します。
   *
   * @param isDeleted 削除済みの場合 true 、 未削除の場合 false 。
   */
  public void setIsDeleted(boolean isDeleted) {
    this.isDeleted = new IsDeleted(isDeleted);
  }
}