package com.memoblend.applicationcore.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

/**
 * ユーザーのドメインサービスです。
 */
@AllArgsConstructor
@Component
public class UserDomainService {
  @Autowired
  private UserRepository userRepository;

  /**
   * ユーザーが存在するかどうかを判定します。
   * 
   * @param user ユーザー。
   * @return ユーザーが存在する場合は true、存在しない場合は false。
   */
  public boolean isExistUser(User user) {
    return userRepository.findById(user.getId()) != null;
  }
}
