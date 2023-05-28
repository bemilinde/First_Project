package com.project.quizzeria.service;

import com.project.quizzeria.dto.QuizReplyDTO;
import com.project.quizzeria.entity.QuizReply;

import java.util.List;

public interface QuizReplyService {

    Long register(QuizReplyDTO dto);


    List<QuizReply> getList(long qno);

    QuizReplyDTO read(Long qrno);

    void modify(QuizReplyDTO dto);

    default QuizReply dtoToEntity(QuizReplyDTO dto){
        QuizReply entity = QuizReply.builder()
                .qrno(dto.getQrno())
                .content(dto.getContent())
                .quiz(dto.getQuiz())
                .member(dto.getMember())
                .hidden(dto.getHidden())
                .likes(dto.getLikes())
                .build();
        return entity;
    }

    default QuizReplyDTO entityToDTO(QuizReply entity){
        QuizReplyDTO dto = QuizReplyDTO.builder()
                .qrno(entity.getQrno())
                .content(entity.getContent())
                .quiz(entity.getQuiz())
                .member(entity.getMember())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .hidden(entity.getHidden())
                .likes(entity.getLikes())
                .build();
        return dto;
    }
}
