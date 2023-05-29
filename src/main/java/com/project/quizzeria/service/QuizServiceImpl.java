package com.project.quizzeria.service;

import com.project.quizzeria.dto.BoardDTO;
import com.project.quizzeria.dto.PageRequestDTO;
import com.project.quizzeria.dto.PageResultDTO;
import com.project.quizzeria.dto.QuizDTO;
import com.project.quizzeria.entity.Board;
import com.project.quizzeria.entity.Quiz;
import com.project.quizzeria.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Log4j2
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Override
    public Long create(QuizDTO dto) {
        log.info("Quiz Create start");
        Quiz entity = dtoToEntity(dto);
        quizRepository.save(entity);
        log.info("Quiz Create End");
        return entity.getQno();
    }

    @Override
    public PageResultDTO<QuizDTO, Quiz> getQuiz(PageRequestDTO requestDTO){
        log.info("Quiz Page Build Start");
        Pageable pageable = requestDTO.getPageable(Sort.by("qno").descending());
        Page<Quiz> result = quizRepository.findAll(pageable);
        Function<Quiz, QuizDTO> fn = (entity->entityToDTO(entity));
        log.info("Board Page Build End");
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public QuizDTO getRandomQuiz() {
        // 데이터베이스에서 랜덤한 퀴즈를 가져옵니다.
        Quiz randomQuiz = quizRepository.findRandomQuiz(); // 이 메서드는 리포지토리에서 구현해야 합니다.

        // Quiz 엔티티를 QuizDTO로 변환합니다.
        QuizDTO randomQuizDTO = entityToDTO(randomQuiz);

        return randomQuizDTO;
    }



}
