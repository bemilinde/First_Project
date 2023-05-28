package com.project.quizzeria.service;

import com.project.quizzeria.dto.NoticeFileDTO;
import com.project.quizzeria.entity.NoticeFile;
import com.project.quizzeria.repository.NoticeFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoticeFileServiceImpl implements NoticeFileService{

    private final NoticeFileRepository repository;

    @Override
    @Transactional
    public Long saveFile(NoticeFileDTO dto){
        log.info("NoticeFile Save Start");
        NoticeFile entity = dtoToEntity(dto);
        log.info("NoticeFile Save End");
        return entity.getNfno();
    }
}
