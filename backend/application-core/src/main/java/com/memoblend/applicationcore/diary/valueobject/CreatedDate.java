package com.memoblend.applicationcore.diary.valueobject;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class CreatedDate {
    private final LocalDate value;

    /**
     * {@link CreatedDate} クラスの新しいインスタンスを初期化します。
     * 
     * @param value 作成日時の値。
     * @throws IllegalArgumentException 作成日時の値が 0 未満の場合。
     */
    public CreatedDate(LocalDate value) {
        if (value == null) {
            throw new IllegalArgumentException("{0} は null にできません");
        }
        this.value = value;
    }
}
