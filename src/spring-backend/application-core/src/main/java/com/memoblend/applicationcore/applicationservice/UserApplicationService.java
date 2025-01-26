package com.memoblend.applicationcore.applicationservice;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.memoblend.applicationcore.user.User;
import com.memoblend.applicationcore.user.UserNotFoundException;
import com.memoblend.applicationcore.user.UserRepository;
import com.memoblend.systemcommon.constant.LoggerConstant;
import lombok.AllArgsConstructor;

/**
 * ユーザーのアプリケーションサービスです。
 */
@Service
@AllArgsConstructor
public class UserApplicationService {

  @Autowired
  private UserRepository userRepository;

  private final Logger apLog = Logger.getLogger(LoggerConstant.APPLICATION_LOGGER);

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
   * @param userId ユーザーID。
   * @return 条件に合うユーザー。
   * @throws UserNotFoundException ユーザーが見つからない場合。
   */
  public User getUser(long userId) throws UserNotFoundException {
    apLog.info("ユーザーIDが、" + userId + "のユーザーを取得します。");
    User user = userRepository.findById(userId);
    if (user == null) {
      apLog.info("ユーザーIDが、" + userId + "のユーザーが見つかりませんでした。");
      throw new UserNotFoundException(userId);
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
}
