package com.project.quizzeria.dto;

import com.project.quizzeria.entity.Member;
import com.project.quizzeria.entity.NoticeFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticeDTO {
    private Long nno;

    private String title;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private String category;

    private Member member;

    private String hidden;

    private Long views;

    private Long likes;

    private List<NoticeFile> noticeFile;
}
