package com.memoblend.infrastructure.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.memoblend.applicationcore.user.User;

/**
 * ユーザーのマッパーです。
 */
@Mapper
public interface UserMapper {

   /**
    * ユーザーを全件取得します。
    * 
    * @return 全てのユーザー 。
    */
   public List<User> findAll();

   /**
    * IDを指定して、
    * {@link User} を取得します。
    * 
    * @param id ユーザーID。
    * @return 条件に合うユーザー。
    */
   public User findById(long id);

   /**
    * ユーザーを追加します。
    * 
    * @param user 追加するユーザー。
    */
   public long add(User user);

   /**
    * ID を指定して、 {@link User} を削除します。
    * 
    * @param id 削除するユーザーの ID。
    */
   public long delete(long id);

   /**
    * {@link User} を更新します。
    * 
    * @param user 更新するユーザー。
    */
   public long update(User user);
}
