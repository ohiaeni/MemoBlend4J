package com.memoblend.applicationcore.diary;

import java.time.LocalDate;

import com.memoblend.applicationcore.diary.valueobject.Content;
import com.memoblend.applicationcore.diary.valueobject.CreatedDate;
import com.memoblend.applicationcore.diary.valueobject.Id;
import com.memoblend.applicationcore.diary.valueobject.IsDeleted;
import com.memoblend.applicationcore.diary.valueobject.Title;
import com.memoblend.applicationcore.diary.valueobject.UserId;

/**
 * 日記のドメインモデルです。
 */
public class Diary {

  private Id id;
  private UserId userId;
  private Title title;
  private Content content;
  private CreatedDate createdDate;
  private IsDeleted isDeleted;

  /**
   * {@link Diary} クラスの新しいインスタンスを初期化します。
   * 
   * @param id          ID。
   * @param userId      ユーザー ID。
   * @param title       タイトル。
   * @param content     内容。
   * @param createdDate 作成日時。
   * @param isDeleted   削除フラグ。
   */
  public Diary(long id, long userId, String title, String content, LocalDate createdDate, boolean isDeleted) {
    this.id = new Id(id);
    this.userId = new UserId(userId);
    this.title = new Title(title);
    this.content = new Content(content);
    this.createdDate = new CreatedDate(createdDate);
    this.isDeleted = new IsDeleted(isDeleted);
  }

  /**
   * ID を取得します。
   * 
   * @return ID。
   */
  public long getId() {
    return this.id.getValue();
  }

  /**
   * ユーザー ID を取得します。
   * 
   * @return ユーザー ID。
   */
  public long getUserId() {
    return this.userId.getValue();
  }

  /**
   * タイトルを取得します。
   * 
   * @return タイトル。
   */
  public String getTitle() {
    return this.title.getValue();
  }

  /**
   * 内容を取得します。
   * 
   * @return 内容。
   */
  public String getContent() {
    return this.content.getValue();
  }

  /**
   * 作成日時を取得します。
   * 
   * @return 作成日時。
   */
  public LocalDate getCreatedDate() {
    return this.createdDate.getValue();
  }

  /**
   * 削除フラグを取得します。
   * 
   * @return 削除フラグ。
   */
  public boolean getIsDeleted() {
    return this.isDeleted.isValue();
  }

  /**
   * ID を設定します。
   * 
   * @param id ID。
   */
  public void setId(long id) {
    this.id = new Id(id);
  }

  /**
   * ユーザー ID を設定します。
   * 
   * @param userId ユーザー ID。
   */
  public void setUserId(long userId) {
    this.userId = new UserId(userId);
  }

  /**
   * タイトルを設定します。
   * 
   * @param title タイトル。
   */
  public void setTitle(String title) {
    this.title = new Title(title);
  }

  /**
   * 内容を設定します。
   * 
   * @param content 内容。
   */
  public void setContent(String content) {
    this.content = new Content(content);
  }

  /**
   * 作成日時を設定します。
   * 
   * @param createdDate 作成日時。
   */
  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = new CreatedDate(createdDate);
  }

  /**
   * 削除フラグを設定します。
   * 
   * @param isDeleted 削除フラグ。
   */
  public void setIsDeleted(boolean isDeleted) {
    this.isDeleted = new IsDeleted(isDeleted);
  }
}
