package com.memoblend.applicationcore.diary.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Content {
    private final String value;

    /**
     * {@link Content} クラスの新しいインスタンスを初期化します。
     * 
     * @param value コンテンツの値。
     * @throws IllegalArgumentException コンテンツの値が null か指定の文字数範囲外の場合。
     */
    public Content(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("{0} は {1} 文字以上入力してください");
        }
        if (value.length() < 1 || value.length() > 1000) {
            throw new IllegalArgumentException("{0} は {1} ～ {2} 文字の範囲で入力してください");
        }
        this.value = value;
    }
}
