package com.memoblend.applicationcore.diary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

/**
 * Diary クラスのテストクラスです。
 */
public class DiaryTest {

  @Test
  public void testNoError_正常系_日記を作成できる() {
    assertDoesNotThrow(() -> new Diary(1L, 1L, "testTitle", "testContent", LocalDate.of(2025, 1, 1), false));
  }

  @Test
  public void testIdSetZero_正常系_idが0() {
    assertDoesNotThrow(() -> new Diary(0L, 1L, "testTitle", "testContent", LocalDate.of(2025, 1, 1), false));
  }

  @Test
  public void testIdIsNegative_異常系_IDが負の数() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Diary(-1L, 1L, "testTitle", "testContent", LocalDate.of(2025, 1, 1), false));
    assertEquals("{0} は {1} 以上の値にしてください", e.getMessage());
  }

  @Test
  public void testUserIdSetZero_正常系_userIdが0() {
    assertDoesNotThrow(() -> new Diary(1L, 0L, "testTitle", "testContent", LocalDate.of(2025, 1, 1), false));
  }

  @Test
  public void testUserIdIsNegative_異常系_userIdが負の数() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Diary(1L, -1L, "testTitle", "testContent", LocalDate.of(2025, 1, 1), false));
    assertEquals("{0} は {1} 以上の値にしてください", e.getMessage());
  }

  @Test
  public void testTitleIsNull_異常系_titleがnull() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Diary(1L, 1L, null, "testContent", LocalDate.of(2025, 1, 1), false));
    assertEquals("{0} は {1} 文字以上入力してください", e.getMessage());
  }

  @Test
  public void testTitleIsBlank_異常系_titleが空白() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Diary(1L, 1L, " ", "testContent", LocalDate.of(2025, 1, 1), false));
    assertEquals("{0} は {1} 文字以上入力してください", e.getMessage());
  }

  @Test
  public void testTitleIsTooShort_異常系_titleが0文字() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Diary(1L, 1L, "", "testContent", LocalDate.of(2025, 1, 1), false));
    assertEquals("{0} は {1} 文字以上入力してください", e.getMessage());
  }

  @Test
  public void testTitleIsTooLong_異常系_titleの文字数オーバー() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Diary(1L, 1L, "a".repeat(101), "testContent", LocalDate.of(2025, 1, 1), false));
    assertEquals("{0} は {1} ～ {2} 文字の範囲で入力してください", e.getMessage());
  }

  @Test
  public void testContentIsNull_異常系_contentがnull() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Diary(1L, 1L, "testTitle", null, LocalDate.of(2025, 1, 1), false));
    assertEquals("{0} は {1} 文字以上入力してください", e.getMessage());
  }

  @Test
  public void testContentIsBlank_異常系_contentが空白() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Diary(1L, 1L, "testTitle", " ", LocalDate.of(2025, 1, 1), false));
    assertEquals("{0} は {1} 文字以上入力してください", e.getMessage());
  }

  @Test
  public void testContentIsTooShort_異常系_contentが0文字() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Diary(1L, 1L, "testTitle", "", LocalDate.of(2025, 1, 1), false));
    assertEquals("{0} は {1} 文字以上入力してください", e.getMessage());
  }

  @Test
  public void testDateIsNull_異常系_日付がnull() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Diary(1L, 1L, "testTitle", "testContent", null, false));
    assertEquals("{0} は必須です", e.getMessage());
  }

  @Test
  public void testIsDeletedIsFalse_正常系_isDeletedがfalse() {
    assertDoesNotThrow(() -> new Diary(1L, 1L, "testTitle", "testContent", LocalDate.of(2025, 1, 1), false));
  }

  @Test
  public void testIsDeletedIsTrue_正常系_isDeletedがtrue() {
    assertDoesNotThrow(() -> new Diary(1L, 1L, "testTitle", "testContent", LocalDate.of(2025, 1, 1), true));
  }
}
