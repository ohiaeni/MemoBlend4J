package com.memoblend.web.controller.dto.util;

import java.util.List;
import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.applicationcore.user.User;
import com.memoblend.web.controller.dto.diary.GetDiariesResponse;
import com.memoblend.web.controller.dto.diary.GetDiaryResponse;
import com.memoblend.web.controller.dto.diary.PostDiaryRequest;
import com.memoblend.web.controller.dto.user.GetUserResponse;
import com.memoblend.web.controller.dto.user.GetUsersResponse;
import com.memoblend.web.controller.dto.user.PostUserRequest;

/**
 * dto とオブジェクトの変換を行うクラスです。
 */
public class DataTransferObjectConverter {

  public static GetDiariesResponse diariesConverter(List<Diary> diaries) {
    GetDiariesResponse response = new GetDiariesResponse(diaries);
    return response;
  }

  /**
   * 日記オブジェクトから各属性を取り出し、DTOとして返します。
   * 
   * @param diary 日記オブジェクト
   * @return DTOとしての日記情報
   */
  public static GetDiaryResponse diaryConverter(Diary diary) {
    return new GetDiaryResponse(diary.getId(), diary.getUserId(), diary.getTitle(), diary.getContent(),
        diary.getDate());
  }

  /**
   * Postから日記オブジェクトを作成し、返します。
   * 
   * @param request 日記情報
   * @return 日記オブジェクト
   */
  public static Diary diaryConverter(PostDiaryRequest request) {
    return new Diary(request.getId(), request.getUserId(), request.getTitle(), request.getContent(),
        request.getDate());
  }

  public static GetUsersResponse usersConverter(List<User> users) {
    GetUsersResponse response = new GetUsersResponse(users);
    return response;
  }
  
  /**
   * ユーザーオブジェクトから各属性を取り出し、DTOとして返します。
   * 
   * @param user ユーザーオブジェクト
   * @return DTOとしてのユーザー情報
   */
  public static GetUserResponse userConverter(User user) {
    return new GetUserResponse(user.getUserId(), user.getUserName());
  }

  /**
   * Postからユーザーオブジェクトを作成し、返します。
   * 
   * @param request ユーザー情報
   * @return ユーザーオブジェクト
   */
  public static User userConverter(PostUserRequest request) {
    return new User(request.getUserId(), request.getUserName());
  }
}
