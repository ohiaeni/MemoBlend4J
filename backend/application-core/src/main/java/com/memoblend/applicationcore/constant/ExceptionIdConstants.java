package com.memoblend.applicationcore.constant;

/**
 * 業務例外 ID 用の定数クラスです。
 */
public class ExceptionIdConstants {

  /** 日記ID:{0}の日記が見つかりませんでした。 */
  public static final String E_DIARY_NOT_FOUND = "diaryNotFound";

  /** ユーザーID：{0}のユーザーが見つかりませんでした。 */
  public static final String E_USER_NOT_FOUND = "userNotFound";

  /** ユーザーID：{0}は必須です。 */
  public static final String E_USER_ID_IS_NULL = "userIdIsNull";

  /** ユーザーID：{0}は0以上の値にしてください。 */
  public static final String E_USER_ID_IS_NEGATIVE = "userIdIsNegative";

  /** ユーザー名：{0}は必須です。 */
  public static final String E_USER_NAME_IS_BRANK = "userNameIsBrank";

  /** ユーザー名：{0}は1～15文字の範囲で入力してください。*/
  public static final String E_USER_NAME_IS_ERROR = "userNameIsERROR";

  /** {0} を実行する権限がありません。 */
  public static final String E_PERMISSION_DENIED = "permissionDenied";
}
