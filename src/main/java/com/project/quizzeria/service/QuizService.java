package com.project.quizzeria.service;

import com.project.quizzeria.dto.BoardDTO;
import com.project.quizzeria.dto.PageRequestDTO;
import com.project.quizzeria.dto.PageResultDTO;
import com.project.quizzeria.dto.QuizDTO;
import com.project.quizzeria.entity.Board;
import com.project.quizzeria.entity.Quiz;

import java.util.List;

public interface QuizService {

    Long create(QuizDTO dto);

    PageResultDTO<QuizDTO, Quiz> getQuiz(PageRequestDTO requestDTO);

    QuizDTO read(Long qno);

    QuizDTO getRandomQuiz();

    QuizDTO getQuiz(Long qno);

    void quizDelete(Long bno);

    default Quiz dtoToEntity(QuizDTO dto){
        Quiz entity = Quiz.builder()
                .qno(dto.getQno())
                .member(dto.getMember())
                .title(dto.getTitle())
                .choices(dto.getChoices())
                .question(dto.getQuestion())
                .answer(dto.getAnswer())
                .build();
        return entity;
    }

    default QuizDTO entityToDTO(Quiz entity){
        QuizDTO dto = QuizDTO.builder()
                .qno(entity.getQno())
                .member(entity.getMember())
                .title(entity.getTitle())
                .choices(entity.getChoices())
                .question(entity.getQuestion())
                .answer(entity.getAnswer())
                .build();
        return dto;
    }

}
