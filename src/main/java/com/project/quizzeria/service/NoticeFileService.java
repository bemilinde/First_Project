package com.project.quizzeria.service;


import com.project.quizzeria.dto.NoticeFileDTO;
import com.project.quizzeria.entity.NoticeFile;

public interface NoticeFileService {


    public Long saveFile(NoticeFileDTO dto);
    default NoticeFile dtoToEntity(NoticeFileDTO dto){
        NoticeFile entity = NoticeFile.builder()
                .nfno(dto.getNfno())
                .ofile(dto.getOfile())
                .sfile(dto.getSfile())
                .filePath(dto.getFilePath())
                .hidden(dto.getHidden())
                .build();
        return entity;
    }

    default NoticeFileDTO entityToDTO(NoticeFile entity){
        NoticeFileDTO dto = NoticeFileDTO.builder()
                .nfno(entity.getNfno())
                .ofile(entity.getOfile())
                .sfile(entity.getSfile())
                .filePath(entity.getFilePath())
                .hidden(entity.getHidden())
                .build();
        return dto;
    }
}
