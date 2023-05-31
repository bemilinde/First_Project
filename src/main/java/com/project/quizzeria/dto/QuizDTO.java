package com.project.quizzeria.dto;

import com.project.quizzeria.entity.Member;
import com.project.quizzeria.entity.Quiz;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class QuizDTO {
    private Long qno;
    private Member member;
    private String title;
    private List<String> choices;
    private String question;
    private String answer;

}