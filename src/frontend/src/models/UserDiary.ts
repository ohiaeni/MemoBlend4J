/**
 * 日記のドメインモデルです。
 */
export default class UserDiary {
    private _title: string;
    private _content: string;
    private _created_at: Date;
    private _updated_at: Date;

    /**
     * コンストラクタ。
     * @param created_at 作成日付。
     * @param title      タイトル。
     * @param content    コンテンツ。
     */
    constructor(title: string, content: string, created_at: Date) {
        this._title = title;
        this._content = content;
        this._created_at = created_at;
        this._updated_at = created_at;
    }

    /**
     * タイトルの getter 。
     */
    get title(): string {
        return this._title;
    }

    /**
     * タイトルの setter 。
     */
    set title(title: string) {
        this._title = title;
    }

    /**
     * コンテンツの getter 。
     */
    get content(): string {
        return this._content;
    }

    /**
     * コンテンツの setter 。
     */
    set content(content: string) {
        this._content = content;
    }

    /**
     * 作成日時の getter 。
     */
    get created_at(): Date {
        return this._created_at;
    }

    /**
     * 更新日時の getter 。
     */
    get updated_at(): Date {
        return this._updated_at;
    }

    /**
     * 更新日時の setter。
     */
    set updated_at(updated_at: Date) {
        this._updated_at = updated_at;
    }
}
