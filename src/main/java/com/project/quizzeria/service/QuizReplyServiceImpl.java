package com.project.quizzeria.service;

import com.project.quizzeria.dto.QuizReplyDTO;
import com.project.quizzeria.entity.QuizReply;
import com.project.quizzeria.repository.QuizReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuizReplyServiceImpl implements QuizReplyService{
    private final QuizReplyRepository repository;

    @Override
    public Long register(QuizReplyDTO dto) {
        log.info("QuizReply Register Start");
        QuizReply entity = dtoToEntity(dto);
        repository.save(entity);
        log.info("QuizReply Register End");
        return entity.getQrno();
    }

    @Override
    public List<QuizReply> getList(long qno){
        log.info("QuizReply Page Build Start");
        List<QuizReply> quizReply = repository.findAllById(Collections.singleton(qno));
        log.info("QuizReply Page Build End");
        return quizReply;
    }

    @Override
    public QuizReplyDTO read(Long qrno){
        log.info("QuizReply Read Start");
        Optional<QuizReply> result = repository.findById(qrno);
        log.info("QuizReply Read End");
        return result.isPresent() ? entityToDTO(result.get()) : null;
    }

    @Override
    public void modify(QuizReplyDTO dto){
        log.info("QuizReply Modify Start");
        Optional<QuizReply> result = repository.findById(dto.getQrno());

        if(result.isPresent()){
            QuizReply entity = result.get();

            entity.changeContent(dto.getContent());

            log.info("QuizReply Modify Success");
            repository.save(entity);
        }
        log.info("QuizReply Modify End");
    }
}
