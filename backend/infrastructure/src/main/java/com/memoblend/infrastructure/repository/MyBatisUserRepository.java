package com.memoblend.infrastructure.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.memoblend.applicationcore.user.User;
import com.memoblend.applicationcore.user.UserRepository;
import com.memoblend.infrastructure.repository.entity.UserEntity;
import com.memoblend.infrastructure.repository.mapper.UserMapper;
import com.memoblend.infrastructure.repository.translator.EntityTranslator;

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
    List<UserEntity> entities = userMapper.findAll();
    List<User> users = entities.stream().map(entity -> {
      return EntityTranslator.translate(entity);
    }).toList();
    return users;
  }

  @Override
  public User findById(long id) {
    UserEntity entity = userMapper.findById(id);
    User user = EntityTranslator.translate(entity);
    return user;
  }

  @Override
  public User add(User user) {
    UserEntity entity = EntityTranslator.translate(user);
    userMapper.add(entity);
    User addedUser = EntityTranslator.translate(entity);
    return addedUser;
  }

  @Override
  public long delete(long id) {
    return userMapper.delete(id);
  }

  @Override
  public long update(User user) {
    UserEntity entity = EntityTranslator.translate(user);
    return userMapper.update(entity);
  }
}