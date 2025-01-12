package com.memoblend.infrastructure.diary;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.memoblend.applicationcore.diary.Diary;
import com.memoblend.applicationcore.diary.DiaryRepository;

@Component
public class DiaryRepositoryImpl implements DiaryRepository {

    @Override
    public Optional<Diary> findByDate(LocalDate date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDate'");
    }

    @Override
    public void add(Diary diary) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    
}
