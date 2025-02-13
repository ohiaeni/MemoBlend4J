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
  public User findById(long id) {
    return userMapper.findById(id);
  }

  @Override
  public User add(User user) {
    userMapper.add(user);
    User addedUser = user;
    return addedUser;
  }

  @Override
  public long delete(long id) {
    return userMapper.delete(id);
  }

  @Override
  public long update(User user) {
    return userMapper.update(user);
  }
}