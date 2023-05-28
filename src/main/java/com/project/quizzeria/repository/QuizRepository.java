package com.project.quizzeria.repository;

import com.project.quizzeria.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long>
        , QuerydslPredicateExecutor<Quiz> {

    @Query("SELECT q FROM Quiz q WHERE q.quizList.qlno = :qlno AND q.hidden not like 'Y'")
    List<Quiz> findAllByQlno(long qlno);
}