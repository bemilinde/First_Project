package com.project.quizzeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizFileDTO {
    private Long qfno;

    private String ofile;

    private String sfile;

    private String filePath;

    private String hidden;
}
