package com.memoblend.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEntity {
  private long id;

  private String name;

  private boolean isDeleted;
}
