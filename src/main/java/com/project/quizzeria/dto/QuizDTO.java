package com.project.quizzeria.dto;

import com.project.quizzeria.entity.QuizAnswer;
import com.project.quizzeria.entity.QuizFile;
import com.project.quizzeria.entity.QuizList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizDTO {
    private Long qno;

    private String question;

    private QuizList quizList;

    private String type;

    private String hidden;

    private Long likes;

    private List<QuizAnswer> quizAnswer;

    private List<QuizFile> quizFile;
}
