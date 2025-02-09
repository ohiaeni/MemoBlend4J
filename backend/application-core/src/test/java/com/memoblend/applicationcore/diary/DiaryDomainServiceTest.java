package com.memoblend.applicationcore.diary;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 日記のドメインサービスのテストクラスです。
 */
@ExtendWith(SpringExtension.class)
public class DiaryDomainServiceTest {

  @Mock
  private DiaryRepository diaryRepository;

  private DiaryDomainService diaryDomainService;

  @BeforeEach
  void setUp() {
    diaryDomainService = new DiaryDomainService(diaryRepository);
  }

  @Test
  void testIsExistDiary_正常系_日記が存在する場合はtrueを返す() {
    // Arrange
    LocalDate date = LocalDate.of(2025, 1, 1);
    Diary diary = createDiary(date);
    long id = diary.getId();
    when(diaryRepository.findById(id)).thenReturn(diary);
    // Act
    boolean actual = diaryDomainService.isExistDiary(id);
    // Assert
    assertTrue(actual);
  }

  @Test
  void testIsExistDiary_正常系_日記が存在しない場合はfalseを返す() {
    // Arrange
    LocalDate date = LocalDate.of(2025, 1, 1);
    Diary diary = createDiary(date);
    long id = diary.getId();
    when(diaryRepository.findById(id)).thenReturn(null);
    // Act
    boolean actual = diaryDomainService.isExistDiary(id);
    // Assert
    assertTrue(!actual);
  }

  private Diary createDiary(LocalDate date) {
    long id = 1;
    long userId = 1;
    String title = "testTitle";
    String content = "testContent";
    Diary diary = new Diary(id, userId, title, content, date);
    return diary;
  }
}
