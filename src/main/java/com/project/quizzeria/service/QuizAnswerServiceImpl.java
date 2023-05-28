package com.project.quizzeria.service;

import com.project.quizzeria.entity.QuizAnswer;
import com.project.quizzeria.repository.QuizAnswerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuizAnswerServiceImpl implements QuizAnswerService{
    private final QuizAnswerRepository repository;

    @Override
    public List<QuizAnswer> read(long qno){
        log.info("QuizAnswer Read Start");
        List<QuizAnswer> quizAnswers = repository.findAll();
        List<QuizAnswer> result = new ArrayList<>();
        for(QuizAnswer dto : quizAnswers){
            if(dto.getQuiz().getQno() == qno){
                result.add(dto);
            }
        }
        log.info("Quiz Read End");

        return result;
    }

}
