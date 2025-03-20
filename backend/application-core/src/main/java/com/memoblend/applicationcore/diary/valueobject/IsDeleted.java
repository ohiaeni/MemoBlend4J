package com.memoblend.applicationcore.diary.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class IsDeleted {
    private final boolean value;

    /**
     * {@link IsDeleted} クラスの新しいインスタンスを初期化します。
     * 
     * @param value 削除フラグの値。
     */
    public IsDeleted(boolean value) {
        this.value = value;
    }
}
