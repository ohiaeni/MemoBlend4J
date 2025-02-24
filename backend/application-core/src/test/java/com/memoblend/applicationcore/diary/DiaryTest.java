
package com.memoblend.applicationcore.diary;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
/**
 * 日記のドメインモデルのテストクラスです。
 */
@ExtendWith(SpringExtension.class)
//@SpringBootTest
public class DiaryTest {
  
  //@Autowired
  Validator validator;

  private Diary diary = new Diary(1L, 1L, "testTitle", "testContent", LocalDate.of(2025, 1, 1));
  private BindingResult bindingResult = new BindException(diary, "Diary");


  @BeforeEach
  public void setUp() {
    LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
    factory.afterPropertiesSet(); // 必須
    this.validator = factory;
    diary.setId(1L);
    diary.setUserId(1L);
    diary.setTitle("testTitle");
    diary.setContent("testContent");
    diary.setDate(LocalDate.of(2025, 1, 1));
  }

  @Test
  public void testNoError_正常系_日記を作成できた場合はtrueを返す() {
    // Act
    validator.validate(diary, bindingResult);
    // Assert
    assertTrue(!bindingResult.hasErrors());
  }

  // @SuppressWarnings("null")
  // @Test
  // public void testIdIsNull_異常系_IDがnull() {
  //   // Arrange
  //   // diary = new Diary(0L, 1L, "testTitle", "testContent", LocalDate.now());
  //   diary.setId((Long) null);
  //   // Act
  //   validator.validate(diary, bindingResult);
  //   // Assert
  //   assertEquals("id", bindingResult.getFieldError().getField());
  //   assertEquals("must not be null", bindingResult.getFieldError().getDefaultMessage());
  // }

  // @Test
  // void testUserIdIsNull_異常系_userIdがNull() {
  //   // Arrange
  //   diary = new Diary(1L, 0L, "testTitle", "testContent", LocalDate.now());
  //   // Act
  //   validator.validate(diary, bindingResult);
  //   // Assert
  //   assertNotNull(bindingResult.hasErrors());
  //   assertEquals("userId", bindingResult.getFieldError().getField());
  // }

  // @Test
  // public void testTitleIsNull_異常系_titleがnull() {
  //   // Arrange
  //   diary = new Diary(0L, 1L, null, "testContent", LocalDate.now());
  //   // Act
  //   validator.validate(diary, bindingResult);
  //   // Assert
  //   assertNotNull(bindingResult.hasErrors());
  //   assertEquals("title", bindingResult.getFieldError().getField());
  // }

  // @Test
  // public void testTitleIsBlank_異常系_titleが空白() {
  //   // Arrange
  //   diary = new Diary(0L, 1L, " ", "testContent", LocalDate.now());
  //   // Act
  //   validator.validate(diary, bindingResult);
  //   // Assert
  //   assertNotNull(bindingResult.hasErrors());
  //   assertEquals("title", bindingResult.getFieldError().getField());
  // }

  // @Test
  // public void testTitleIsTooShort_異常系_文章が0文字() {
  //   // Arrange
  //   diary = new Diary(0L, 1L, "", "testContent", LocalDate.now());
  //   // Act
  //   validator.validate(diary, bindingResult);
  //   // Assert
  //   assertNotNull(bindingResult.hasErrors());
  //   assertEquals("title", bindingResult.getFieldError().getField());
  //   assertEquals("titleは1～30文字の範囲で入力してください", bindingResult.getFieldError().getDefaultMessage());
  // }

  // @Test
  // public void testTitleIsTooLong_異常系_titleの文字数オーバー() {
  //   // Arrange
  //   // diary.setTitle("a".repeat(999));
  //   diary = new Diary(0L, 1L, "a".repeat(999), "testContent", LocalDate.now());
  //   // Act
  //   validator.validate(diary, bindingResult);
  //   // Assert
  //   assertNotNull(bindingResult.hasErrors());
  //   assertEquals("title", bindingResult.getFieldError().getField());
  //   assertEquals("titleは1～30文字の範囲で入力してください", bindingResult.getFieldError().getDefaultMessage());
  // }

  // @Test
  // public void testContentIsNull_異常系_文章がnull() {
  //   // Arrange
  //   // diary.setContent(null);
  //   diary = new Diary(0L, 1L, "testTitle", "null", LocalDate.now());
  //   // Act
  //   validator.validate(diary, bindingResult);
  //   // Assert
  //   assertNotNull(bindingResult.hasErrors());
  //   assertEquals("content", bindingResult.getFieldError().getField());
  //   assertEquals("must not be blank", bindingResult.getFieldError().getDefaultMessage());
  // }

  // @Test
  // public void testContentIsBlank_異常系_文章が空白() {
  //   // Arrange
  //   // diary.setContent(" ");
  //   diary = new Diary(0L, 1L, "testTitle", " ", LocalDate.now());
  //   // Act
  //   validator.validate(diary, bindingResult);
  //   // Assert
  //   assertNotNull(bindingResult.hasErrors());
  //   assertEquals("content", bindingResult.getFieldError().getField());
  //   assertEquals("must not be blank", bindingResult.getFieldError().getDefaultMessage());
  // }

  // @Test
  // public void testContentIsTooShort_異常系_文章が0文字() {
  //   // Arrange
  //   // diary.setContent("");
  //   diary = new Diary(0L, 1L, "testTitle", "", LocalDate.now());
  //   // Act
  //   validator.validate(diary, bindingResult);
  //   // Assert
  //   assertNotNull(bindingResult.hasErrors());
  //   assertEquals("content", bindingResult.getFieldError().getField());
  //   assertEquals("contentは1文字以上入力してください", bindingResult.getFieldError().getDefaultMessage());
  // }

  // @Test
  // public void testDateIsNull_異常系_日付がnull() {
  //   // Arrange
  //   // diary.setDate(null);
  //   diary = new Diary(0L, 1L, "testTitle", "testContent", null);
  //   // Act
  //   validator.validate(diary, bindingResult);
  //   // Assert
  //   assertNotNull(bindingResult.hasErrors());
  //   assertEquals("date", bindingResult.getFieldError().getField());
  // }
}
