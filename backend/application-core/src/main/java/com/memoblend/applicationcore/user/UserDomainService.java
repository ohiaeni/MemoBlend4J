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
   * ID を指定して、ユーザーが存在するかどうかを判定します。
   * 
   * @param id ユーザーの ID 。
   * @return ユーザーが存在する場合は true 、存在しない場合は false 。
   */
  public boolean isExistUser(long id) {
    if (userRepository.findById(id) == null
        || userRepository.findById(id).isDeleted()) {
      return false;
    }
    return true;
  }
}
