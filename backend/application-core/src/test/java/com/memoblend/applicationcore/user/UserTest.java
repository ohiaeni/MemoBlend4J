// package com.memoblend.applicationcore.user;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.validation.BindException;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.Validator;
// import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
// import com.memoblend.applicationcore.constant.ExceptionIdConstants;

// /**
//  * ユーザーのドメインモデルのテストクラスです。
//  */
// @ExtendWith(SpringExtension.class)
// public class UserTest {

//   private User user;
//   private BindingResult bindingResult;
//   private Validator validator;

//   @BeforeEach
//   void setUp() {
//     setUpUser();
//     this.bindingResult = new BindException(user, "User");
//     setUpValidator();
//   }
  
//   @Test
//   public void testNoError_正常系_ユーザーを作成できた場合はtrueを返す() {
//     // Act
//     validator.validate(user, bindingResult);
//     // Assert
//     assertTrue(!bindingResult.hasErrors());
//   }

//   @Test
//   public void testIdSetZero_正常系_idが0() {
//     // Arrange
//     user.setId(0L);
//     // Act
//     validator.validate(user, bindingResult);
//     // Assert
//     assertTrue(!bindingResult.hasErrors());
//   }

//   @Test
//   public void testIdIsNegative_異常系_idが負の数() {
//     // Arrange
//     user.setId(-1L);
//     // Act
//     validator.validate(user, bindingResult);
//     // Assert
//     assertEquals("id", bindingResult.getFieldError().getField());
//     assertEquals(ExceptionIdConstants.E_USER_ID_IS_NEGATIVE, bindingResult.getFieldError().getDefaultMessage());
//   }

//   @Test
//   public void testNameIsNull_異常系_nameがnull() {
//     // Arrange
//     user.setName(null);
//     // Act
//     validator.validate(user, bindingResult);
//     // Assert
//     assertEquals("name", bindingResult.getFieldError().getField());
//     assertEquals(ExceptionIdConstants.E_USER_NAME_IS_BLANK, bindingResult.getFieldError().getDefaultMessage());
//   }
  
//   @Test
//   public void testNameIsBlank_異常系_nameが空白() {
//     // Arrange
//     user.setName(" ");
//     // Act
//     validator.validate(user, bindingResult);
//     // Assert
//     assertEquals("name", bindingResult.getFieldError().getField());
//     assertEquals(ExceptionIdConstants.E_USER_NAME_IS_BLANK, bindingResult.getFieldError().getDefaultMessage());
//   }

//   @Test
//   public void testNameIsTooShort_異常系_nameが0文字() {
//     // Arrange
//     user.setName("");
//     // Act
//     validator.validate(user, bindingResult);
//     // Assert
//     assertEquals("name", bindingResult.getFieldError().getField());
//     assertEquals(ExceptionIdConstants.E_USER_NAME_IS_BLANK, bindingResult.getFieldError().getDefaultMessage());
//   }
  
//   @Test
//   public void testNameIsTooLong_異常系_nameの文字数オーバー() {
//     // Arrange
//     user.setName("a".repeat(999));
//     // Act
//     validator.validate(user, bindingResult);
//     // Assert
//     assertEquals("name", bindingResult.getFieldError().getField());
//     assertEquals(ExceptionIdConstants.E_USER_NAME_LENGTH_IS_OUT_OF_RANGE, 
//         bindingResult.getFieldError().getDefaultMessage());
//   }

//   @Test
//   public void testIsDeletedIsFalse_正常系_isDeletedがfalse() {
//     // Arrange
//     user.setIsDeleted(false);
//     // Act
//     validator.validate(user, bindingResult);
//     // Assert
//     assertTrue(!bindingResult.hasErrors());
//   }

//   @Test
//   public void testIsDeletedIsTrue_正常系_isDeletedがtrue() {
//     // Arrange
//     user.setIsDeleted(true);
//     // Act
//     validator.validate(user, bindingResult);
//     // Assert
//     assertTrue(!bindingResult.hasErrors());
//   }

//   private void setUpUser() {
//     this.user = new User(1L, "testName", false);
//   }
  
//   private void setUpValidator() {
//     LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
//     factory.afterPropertiesSet();
//     this.validator = factory;
//   }
// }
