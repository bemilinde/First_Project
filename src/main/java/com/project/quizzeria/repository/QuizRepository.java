package com.project.quizzeria.repository;

import com.project.quizzeria.entity.Board;
import com.project.quizzeria.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>, QuerydslPredicateExecutor<Quiz> {
    @Query(value = "SELECT * FROM quiz ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quiz findRandomQuiz();

    Quiz findQuizByQno(Long qno);
}