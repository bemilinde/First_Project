package com.project.quizzeria.repository;

import com.project.quizzeria.entity.QuizReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QuizReplyRepository extends JpaRepository<QuizReply, Long>
        , QuerydslPredicateExecutor<QuizReply>
{
}
