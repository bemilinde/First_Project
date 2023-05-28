package com.project.quizzeria.dto;

import com.project.quizzeria.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BoardDTO {
    private Long bno;

    private String title;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private String category;

    private Member member;

    private String hidden;

    private Long views;

    private Long likes;



}
