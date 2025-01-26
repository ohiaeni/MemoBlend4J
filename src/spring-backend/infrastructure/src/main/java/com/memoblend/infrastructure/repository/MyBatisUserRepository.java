package com.memoblend.infrastructure.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.memoblend.applicationcore.user.User;
import com.memoblend.applicationcore.user.UserRepository;
import com.memoblend.infrastructure.repository.mapper.UserMapper;
import lombok.AllArgsConstructor;

/**
 * ユーザーのリポジトリです。
 */
@Repository
@AllArgsConstructor
public class MyBatisUserRepository implements UserRepository {

  @Autowired
  private UserMapper userMapper;

  @Override
  public List<User> findAll() {
    return userMapper.findAll();
  }

  @Override
  public User findById(long userId) {
    return userMapper.findById(userId);
  }

  @Override
  public User add(User user) {
    User addedUser = new User(0, user.getUserName());
    userMapper.add(addedUser);
    user.setUserId(addedUser.getUserId());
    return addedUser;
  }

  @Override
  public long delete(long userId) {
    return userMapper.delete(userId);
  }

  @Override
  public long update(User user) {
    return userMapper.update(user);
  }
}