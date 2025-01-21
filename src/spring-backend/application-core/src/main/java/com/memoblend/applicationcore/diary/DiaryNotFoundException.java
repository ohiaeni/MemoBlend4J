package com.memoblend.applicationcore.diary;

import com.memoblend.systemcommon.exception.LogicException;

/**
 * 日記が見つからない場合の例外です。
 */
public class DiaryNotFoundException extends LogicException {

    /**
     * {@link DiaryNotFoundException} クラスのインスタンスを初期化します。
     * 
     * @param cause 原因例外。
     */
    public DiaryNotFoundException(Throwable cause) {
        super(cause, "DIARY_NOT_FOUND", null, null);
    }

}
