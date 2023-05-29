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
import java.util.Optional;
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
    public QuizDTO read(Long qno) {
        Optional<Quiz> result = quizRepository.findById(qno);
        if (result.isPresent()) {
            Quiz quiz = result.get();
//            quiz.increaseViews(); // 조회수 증가
//            quizRepository.save(board); // 변경된 조회수를 저장
            log.info("Board Read End");
            return entityToDTO(quiz);
        }
        return null;
    }

    @Override
    public QuizDTO getQuiz(Long qno) {
        Quiz getQuiz = quizRepository.findQuizByQno(qno);
        if (getQuiz != null) {
            QuizDTO getQuizDTO = new QuizDTO();
            getQuizDTO.setQno(getQuiz.getQno());
            getQuizDTO.setMember(getQuiz.getMember());
            getQuizDTO.setTitle(getQuiz.getTitle());
            getQuizDTO.setQuestion(getQuiz.getQuestion());
            getQuizDTO.setChoices(getQuiz.getChoices());
            getQuizDTO.setAnswer(getQuiz.getAnswer());
            return getQuizDTO;
        }
        return null;
    }

    @Override
    public QuizDTO getRandomQuiz() {

        Quiz randomQuiz = quizRepository.findRandomQuiz();
        QuizDTO randomQuizDTO = entityToDTO(randomQuiz);

        return randomQuizDTO;
    }

    @Override
    public void quizDelete(Long qno) {
        log.info("Board Delete Start");
        quizRepository.deleteById(qno);
        log.info("Board Delete End");
    }



}
