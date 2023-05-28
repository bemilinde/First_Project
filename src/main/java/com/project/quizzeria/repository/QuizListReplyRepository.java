package com.project.quizzeria.repository;

import com.project.quizzeria.entity.QuizListReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.ArrayList;

public interface QuizListReplyRepository extends JpaRepository<QuizListReply, Long>
        , QuerydslPredicateExecutor<QuizListReply>
{
    @Query("SELECT qlr FROM QuizListReply qlr WHERE qlr.quizList.qlno = :qlno")
    ArrayList<QuizListReply> findAllByQlno(long qlno);
}
