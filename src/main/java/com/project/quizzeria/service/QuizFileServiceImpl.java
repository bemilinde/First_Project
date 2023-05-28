package com.project.quizzeria.service;

import com.project.quizzeria.dto.QuizFileDTO;
import com.project.quizzeria.entity.QuizFile;
import com.project.quizzeria.repository.QuizFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuizFileServiceImpl implements QuizFileService{

    private final QuizFileRepository repository;

    @Override
    @Transactional
    public Long saveFile(QuizFileDTO dto){
        log.info("QuizFile Save Start");
        QuizFile entity = dtoToEntity(dto);
        log.info("QuizFile Save End");
        return entity.getQfno();
    }
}
