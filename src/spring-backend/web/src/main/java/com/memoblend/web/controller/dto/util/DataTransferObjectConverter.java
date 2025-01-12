package com.memoblend.web.controller.dto.util;

import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.web.controller.dto.diary.GetDiaryResponse;

public class DataTransferObjectConverter {
    
    public static GetDiaryResponse DiaryConverter(Diary diary) {
        return new GetDiaryResponse(diary.getDate(), diary.getDiaryId(), diary.getTitle(), diary.getContent(), diary.getUserId());
    }
}
