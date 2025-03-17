package com.memoblend.applicationcore.user;

import com.memoblend.applicationcore.user.valueobject.Id;
import com.memoblend.applicationcore.user.valueobject.IsDeleted;
import com.memoblend.applicationcore.user.valueobject.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ユーザーのドメインモデルです。
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true) 
public class User {

  private Id id;
  
  private Name name;

  private IsDeleted isDeleted;
}