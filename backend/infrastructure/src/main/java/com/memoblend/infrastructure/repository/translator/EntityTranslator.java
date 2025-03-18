package com.memoblend.infrastructure.repository.translator;

import com.memoblend.applicationcore.user.User;
import com.memoblend.applicationcore.user.valueobject.Id;
import com.memoblend.applicationcore.user.valueobject.IsDeleted;
import com.memoblend.applicationcore.user.valueobject.Name;
import com.memoblend.infrastructure.repository.entity.UserEntity;

public class EntityTranslator {
  /**
   * User ドメインを UserEntity に変換します。
   * 
   * @param user User ドメイン。
   * @return UserEntity エンティティ。
   */
  public static UserEntity translate(User user) {
    long id = user.getId().getValue();
    String name = user.getName().getValue();
    boolean isDeleted = user.getIsDeleted().isValue();
    UserEntity userEntity = new UserEntity(id, name, isDeleted);
    return userEntity;
  }

  /**
   * UserEntity を User ドメインに変換します。
   * 
   * @param userEntity UserEntity エンティティ。
   * @return User ドメイン。
   */
  public static User translate(UserEntity userEntity) {
    Id id = new Id(userEntity.getId());
    Name name = new Name(userEntity.getName());
    IsDeleted isDeleted = new IsDeleted(userEntity.isDeleted());
    User user = new User(id, name, isDeleted);
    return user;
  }
}
