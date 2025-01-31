package com.memoblend.web.controller.dto.mapper;

import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.web.controller.dto.diary.PostDiaryRequest;

public class PostDiaryRequestMapper {

    /**
     * {@link PostDiaryRequest} を {@link Diary} に変換します。
     * 
     * @param request リクエスト。
     * @return 日記。
     */
    public static Diary convert(PostDiaryRequest request) {
        Diary diary = new Diary(
                request.getId(),
                request.getUserId(),
                request.getTitle(),
                request.getContent(),
                request.getDate());
        return diary;
    }
}
