package com.project.quizzeria.repository;

import com.project.quizzeria.entity.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QuizAnswerRepository  extends JpaRepository<QuizAnswer, Long>
        , QuerydslPredicateExecutor<QuizAnswer> {

}
