# アーキテクチャ
## プレゼンテーション層
### コントローラ
- 日記の追加
- 日記の削除
- 日記の編集
- 日記の一覧表示
- 日記の個別表示


### Data Transfer Object
1. class UserData：ユーザーDTO
    - private int user_id：
        - 属性。ユーザーidの値を格納する。※値オブジェクトではないことに注意
    - private string user_name：
        - 属性。ユーザーNameの値を格納する。※値オブジェクトではないことに注意
    - public UserData(User user)：
        - コンストラクタ。
        - 引数であるuserの情報をthis.user_idとthis.user_nameに格納。
    - public int get_user_id():
        - 関数。ユーザーidの値を返す。
    - public string get_user_name()：
        - 関数。ユーザーNameの値を返す。

2. class DiaryDTO：日記のDTO
    省略。


## アプリケーションコア層
### アプリケーションサービス(業務ロジック)
1. 日記の追加
2. 日記の削除
3. 日記の編集
4. 日記の一覧表示
5. 日記の個別表示

### リポジトリのインターフェイス
1. public interface IUserRepository：ユーザーのインターフェイス
    - void Save(User user)：
        - ユーザーを登録。
    - User Find(UserName user_name)：
        - ユーザーを検索。
    - bool Exists(User user)：
        - ユーザーの重複確認。
    - void Delete(User user)：
        - ユーザーを削除。
    - void UpdateName(UserID user_id, UserName user_name)：
        - ユーザーの名前を変更。

2. public interface IDiaryRepository：日記のインターフェイス
    - void Save(Diary diary)：
        - 日記を登録
    - User Find(DiaryDate diary_date)：
        - 日記を検索(日付で検索)
    - bool Exists(Diary diary)：
        - 日記の重複確認
    - void Delete(Diary diary)：
        - 日記の削除
    - void UpdateLetter(DiaryID diary_id, DiaryText diary_text)：
        - 日記の文章を変更。

## ドメイン層
### エンティティ
1. class User：ユーザーエンティティ
    - private UserId user_id：
        - 属性。ユーザーidの値オブジェクトを格納する。
    - private UserName user_name：
        - 属性。ユーザーNameの値オブジェクトを格納する。
    - public User(UserName user_name)：
        - コンストラクタ。
        - ユーザーNameを引数とし、null判断後、属性に格納する。
        - idの生成を行い、属性に格納する。
    - public UserId get_user_name()：
        - 関数。ユーザーNameの値オブジェクトを返す。
    - public UserName get_user_id()：
        - 関数。ユーザーidの値オブジェクトを返す。
    - public void set_user_name(UserName user_name):
        - 関数。ユーザー名をセットする。

2. class Diary：日記エンティティ
    - private DiaryId diary_id：
        - 属性。日記idの値オブジェクトを格納する。
    - private DiaryDate diary_date：
        - 属性。日付の値オブジェクトを格納する。
    - private DiaryText diary_text：
        - 属性。文章の値オブジェクトを格納する。
    - public Diary(DiaryText diary_text)：
        - 文章を引数としたコンストラクタ。
        - 文章を引数とし、属性に格納。
        - idを生成し、属性に格納する。
        - 日付を生成し、属性に格納する。
    - public DiaryId get_diary_id()：
        - 関数。日記idの値オブジェクトを返す。
    - public DiaryDate get_diary_date()：
        - 関数。日付の値オブジェクトを返す。 
    - public DiaryText get_diary_text()：
        - 関数。文章の値オブジェクトを返す。
    - public void set_diary_text(DiaryText diary_text):
        - 関数。文章をセットする。


### ドメインサービス
1. class UserService：ユーザーのドメインサービス
    - public bool Exists(User user)：重複確認

2. class DiaryService：日記のドメインサービス
    - public bool Exists(User user)：重複確認


### 値オブジェクト
1. class UserId：ユーザーid
    - private int user_id：
        - 属性。ユーザーidを格納する。
    - public UserId(int user_id)：
        - コンストラクタ。ユーザーidを引数とする。
        - nullか空文字の場合、エラー表示。

2. class UserName：ユーザーName
    - private string user_name：
        - 属性。ユーザーNameを格納する。
    - public UserName(string user_name)：
        - コンストラクタ。
        - ユーザーNameを引数とする。
        - nullか空文字の場合、エラー表示。
        - 文字数確認を行う。

3. class DiaryId：日記id
    - private int diary_id：
        - 属性。日記idを格納する。
    - public DiaryId(int diary_id)：
        - コンストラクタ。日記idを引数とする。
        - nullか空文字の場合、エラー表示。

4. class DiaryDate：日記の日付
    - private string diary_date：
        - 属性。日記の日付を格納する。
    - public DiaryDate(string diary_date)：
        - コンストラクタ。日記の日付を引数とする。
        - nullか空文字の場合、エラー表示。

5. class DiaryTitle：日記のタイトル
    - private string diary_title：
        - 属性。日記のタイトルを格納する。
    - public DiaryTitle(string diary_title)：
        - コンストラクタ。日記のタイトルを引数とする。
        - 文字数確認を行う。

6. class LastUpdateDate：日記の最終更新日
    - private string last_update_date：
        - 属性。日記の最終更新日を格納する。
    - public LastUpdateDate(string last_update_date)：
        - コンストラクタ。日記の最終更新日を引数とする。
        - nullか空文字の場合、エラー表示。

7. class DiaryText：日記の文章
    - private string diary_text：
        - 属性。日記の文章を格納する。
    - public DiaryText(string diary_text)：
        - コンストラクタ。日記の文章を引数とする。
        - 文字数確認を行う。

8. class DiaryPhoto：日記の写真(後回し)



## インフラストラクチャ層
### リポジトリの実装クラス
1. 省略
2. 省略


### O/Rマッパー
Python用のORMであるSQLAlchemyを使う。


### DB
第三正規化まで行う。

