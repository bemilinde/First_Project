package com.project.quizzeria.service;

import com.project.quizzeria.dto.BoardDTO;
import com.project.quizzeria.dto.PageRequestDTO;
import com.project.quizzeria.dto.PageResultDTO;
import com.project.quizzeria.entity.Board;

import java.util.List;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO);

    List<Board> getListHome();

    BoardDTO read(Long bno);

    void modify(BoardDTO dto);

    void delete(Long bno);

    void increaseLikes(Long bno);

    default Board dtoToEntity(BoardDTO dto){
        Board entity = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .member(dto.getMember())
                .hidden(dto.getHidden())
                .category(dto.getCategory())
                .views(dto.getViews())
                .likes(dto.getLikes())
                .build();
        return entity;
    }

    default BoardDTO entityToDTO(Board entity){
        BoardDTO dto = BoardDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .member(entity.getMember())
                .hidden(entity.getHidden())
                .category(entity.getCategory())
                .likes(entity.getLikes())
                .views(entity.getViews())
                .build();
        return dto;
    }

}
