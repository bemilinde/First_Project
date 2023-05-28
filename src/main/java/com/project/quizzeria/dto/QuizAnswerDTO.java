package com.project.quizzeria.dto;

import com.project.quizzeria.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizAnswerDTO {
    private Long qano;

    private String answer;

    private String correct;

    private Quiz quiz;

    private String hidden;
}
