package com.project.quizzeria.dto;

import com.project.quizzeria.entity.Member;
import com.project.quizzeria.entity.QuizList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizListReplyDTO {
    private Long qlrno;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private Member member;

    private QuizList quizList;

    private String hidden;

    private Long likes;
}
