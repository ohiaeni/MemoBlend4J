package com.memoblend.applicationcore.diary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * 日記のドメインモデルのテストクラスです。
 */
@ExtendWith(SpringExtension.class)
public class DiaryTest {

  private Diary diary;
  private BindingResult bindingResult;
  private Validator validator;

  @BeforeEach
  void setUp() {
    this.diary = new Diary(1L, 1L, "testTitle", "testContent", LocalDate.of(2025, 1, 1));
    this.bindingResult = new BindException(diary, "Diary");
    LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
    factory.afterPropertiesSet();
    this.validator = factory;
  }

  @Test
  public void testNoError_正常系_日記を作成できた場合はtrueを返す() {
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertTrue(!bindingResult.hasErrors());
  }

  @Test
  public void testIdSetZero_正常系_idが0() {
    // Arrange
    diary.setId(0L);
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertTrue(!bindingResult.hasErrors());
  }

  @Test
  public void testIdIsNull_異常系_idが負の数() {
    // Arrange
    diary.setId(-1L);
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertEquals("id", bindingResult.getFieldError().getField());
    assertEquals("{0}は0以上の値にしてください", bindingResult.getFieldError().getDefaultMessage());
  }

  @Test
  public void testUserIdSetZero_正常系_userIdが0() {
    // Arrange
    diary.setUserId(0L);
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertTrue(!bindingResult.hasErrors());
  }

  @Test
  public void testUserIdIsNull_異常系_userIdが負の数() {
    // Arrange
    diary.setUserId(-1L);
    // Act
    validator.validate(diary, bindingResult);
    // Asert
    assertEquals("userId", bindingResult.getFieldError().getField());
    assertEquals("{0}は0以上の値にしてください", bindingResult.getFieldError().getDefaultMessage());
  }

  @Test
  public void testTitleIsNull_異常系_titleがnull() {
    // Arrange
    diary.setTitle(null);
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertEquals("title", bindingResult.getFieldError().getField());
    assertEquals("{0}は1～30文字の範囲で入力してください", bindingResult.getFieldError().getDefaultMessage());
  }

  @Test
  public void testTitleIsBlank_異常系_titleが空白() {
    // Arrange
    diary.setTitle(" ");
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertEquals("title", bindingResult.getFieldError().getField());
    assertEquals("{0}は1～30文字の範囲で入力してください", bindingResult.getFieldError().getDefaultMessage());
  }

  @Test
  public void testTitleIsTooShort_異常系_titleが0文字() {
    // Arrange
    diary.setTitle("");
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertEquals("title", bindingResult.getFieldError().getField());
    assertEquals("{0}は1～30文字の範囲で入力してください", bindingResult.getFieldError().getDefaultMessage());
  }

  @Test
  public void testTitleIsTooLong_異常系_titleの文字数オーバー() {
    // Arrange
    diary.setTitle("a".repeat(999));
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertEquals("title", bindingResult.getFieldError().getField());
    assertEquals("{0}は1～30文字の範囲で入力してください", bindingResult.getFieldError().getDefaultMessage());
  }

  @Test
  public void testContentIsNull_異常系_contentがnull() {
    // Arrange
    diary.setContent(null);
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertEquals("content", bindingResult.getFieldError().getField());
    assertEquals("{0}は1文字以上入力してください", bindingResult.getFieldError().getDefaultMessage());
  }

  @Test
  public void testContentIsBlank_異常系_contentが空白() {
    // Arrange
    diary.setContent(" ");
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertEquals("content", bindingResult.getFieldError().getField());
    assertEquals("{0}は1文字以上入力してください", bindingResult.getFieldError().getDefaultMessage());
  }

  @Test
  public void testContentIsTooShort_異常系_contentが0文字() {
    // Arrange
    diary.setContent("");
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertEquals("content", bindingResult.getFieldError().getField());
    assertEquals("{0}は1文字以上入力してください", bindingResult.getFieldError().getDefaultMessage());
  }

  @Test
  public void testDateIsNull_異常系_日付がnull() {
    // Arrange
    diary.setDate(null);
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertEquals("date", bindingResult.getFieldError().getField());
    assertEquals("{0}は必須です", bindingResult.getFieldError().getDefaultMessage());
  }
}
