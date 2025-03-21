package com.memoblend.applicationcore.user;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.memoblend.applicationcore.constant.ExceptionIdConstants;

/**
 * ユーザーのドメインモデルのテストクラスです。
 */
@ExtendWith(SpringExtension.class)
public class UserTest {
  
  @Test
  public void testNoError_正常系_ユーザーを作成できる() {
    // Act
    assertDoesNotThrow(() -> new User(1L, "testName",false));
  }

  @Test
  public void testIdSetZero_正常系_idが0() {
    assertDoesNotThrow(() -> new User(0L, "testName",false));
  }

  @Test
  public void testIdIsNegative_異常系_idが負の数() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new User(-1L, "testName", false));
    assertEquals(ExceptionIdConstants.E_USER_ID_IS_NEGATIVE, e.getMessage());
  }

  @Test
  public void testNameIsNull_異常系_nameがnull() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new User(1L, null, false));
    assertEquals(ExceptionIdConstants.E_USER_NAME_IS_NULL, e.getMessage());
  }
  
  @Test
  public void testNameIsBlank_異常系_nameが空白() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new User(1L, " ", false));
    assertEquals(ExceptionIdConstants.E_USER_NAME_IS_BLANK, e.getMessage()); 
  }

  @Test
  public void testNameIsTooShort_異常系_nameが0文字() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new User(1L, "", false));
    assertEquals(ExceptionIdConstants.E_USER_NAME_IS_BLANK, e.getMessage());
  }
  
  @Test
  public void testNameIsTooLong_異常系_nameの文字数オーバー() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new User(1L, "a".repeat(999), false));
    assertEquals(ExceptionIdConstants.E_USER_NAME_LENGTH_IS_OUT_OF_RANGE, e.getMessage());
  }

  @Test
  public void testIsDeletedIsFalse_正常系_isDeletedがfalse() {
    assertDoesNotThrow(() -> new User(1L, "testName",false));
  }

  @Test
  public void testIsDeletedIsTrue_正常系_isDeletedがtrue() {
    assertDoesNotThrow(() -> new User(1L, "testName",true));
  }
}
