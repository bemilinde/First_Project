package com.project.quizzeria.dto;

import com.project.quizzeria.entity.Member;
import com.project.quizzeria.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizReplyDTO {
    private Long qrno;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private Member member;

    private Quiz quiz;

    private String hidden;

    private Long likes;
}
