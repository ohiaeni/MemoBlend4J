package com.memoblend.infrastructure.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.memoblend.applicationcore.user.User;
import com.memoblend.infrastructure.repository.entity.UserEntity;

/**
 * ユーザーの OR マッパークラスです。
 */
@Mapper
public interface UserMapper {

  /**
   * ユーザーを全件取得します。
   * 
   * @return 全てのユーザー。
   */
  public List<UserEntity> findAll();

  /**
   * ID を指定して、{@link UserEntity} を取得します。
   * 
   * @param id ユーザーの ID 。
   * @return 条件に合うユーザー。
   */
  public UserEntity findById(long id);

  /**
   * ユーザーを追加します。
   * 
   * @param user 追加するユーザー。
   * @return 追加したユーザーの数。
   */
  public long add(UserEntity entity);

  /**
   * ID を指定して、 {@link UserEntity} を削除します。
   * 
   * @param id 削除するユーザーの ID 。
   */
  public long delete(long id);

  /**
   * {@link UserEntity} を更新します。
   * 
   * @param user 更新するユーザー。
   */
  public long update(UserEntity entity);
}
