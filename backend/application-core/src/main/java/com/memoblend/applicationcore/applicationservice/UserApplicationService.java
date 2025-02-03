package com.memoblend.applicationcore.applicationservice;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.memoblend.applicationcore.user.User;
import com.memoblend.applicationcore.user.UserNotFoundException;
import com.memoblend.applicationcore.user.UserRepository;
import com.memoblend.systemcommon.constant.SystemPropertyConstants;
import lombok.AllArgsConstructor;

/**
 * ユーザーのアプリケーションサービスです。
 */
@Service
@AllArgsConstructor
public class UserApplicationService {

  @Autowired
  private UserRepository userRepository;

  private final Logger apLog = Logger.getLogger(SystemPropertyConstants.APPLICATION_LOGGER);

  /**
   * 全てのユーザーを取得します。
   * 
   * @return 全てのユーザー。
   */
  public List<User> getUsers() {
    apLog.info("全てのユーザーを取得します。");
    return userRepository.findAll();
  }

  /**
   * ユーザーIDを指定して、
   * {@link User} を取得します。
   * 
   * @param id ユーザーID。
   * @return 条件に合うユーザー。
   * @throws UserNotFoundException ユーザーが見つからない場合。
   */
  public User getUser(long id) throws UserNotFoundException {
    apLog.info("ユーザーIDが、" + id + "のユーザーを取得します。");
    User user = userRepository.findById(id);
    if (user == null) {
      apLog.info("ユーザーIDが、" + id + "のユーザーが見つかりませんでした。");
      throw new UserNotFoundException(id);
    }
    return user;
  }

  /**
   * ユーザーを追加します。
   * 
   * @param user 追加するユーザー。
   * @return 追加されたユーザー。
   */
  public User addUser(User user) {
    final String userName = user.getUserName();
    apLog.info(userName + "を追加します。");
    User addedUser = userRepository.add(user);
    return addedUser;
  }

  /**
   * ユーザーを更新します。
   * 
   * @param user 更新するユーザー。
   */
  public void updateUser(User user) {
    final String userName = user.getUserName();
    apLog.info(userName + "を更新します。");
    userRepository.update(user);
  }

  /**
   * ユーザーを削除します。
   * 
   * @param id   ユーザーのID。
   */
  public void deleteUser(long id) {
    apLog.info("ユーザーID: " + id + "を削除します。");
    userRepository.delete(id);
  }
}
