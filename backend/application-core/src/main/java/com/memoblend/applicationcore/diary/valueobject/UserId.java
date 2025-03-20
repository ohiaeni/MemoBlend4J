package com.memoblend.applicationcore.diary.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class UserId {
    private final long value;

    /**
     * {@link UserId} クラスの新しいインスタンスを初期化します。
     * 
     * @param value ユーザー ID の値。
     * @throws IllegalArgumentException ユーザー ID の値が 0 未満の場合。
     */
    public UserId(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("{0} は {1} 以上の値にしてください");
        }
        this.value = value;
    }
}
