package com.project.quizzeria.service;

import com.project.quizzeria.dto.QuizListReplyDTO;
import com.project.quizzeria.entity.QuizListReply;
import com.project.quizzeria.repository.QuizListReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuizListReplyServiceImpl implements QuizListReplyService{
    private final QuizListReplyRepository repository;

    @Override
    public Long register(QuizListReplyDTO dto) {
        log.info("QuizListReply Register Start");
        QuizListReply entity = dtoToEntity(dto);
        repository.save(entity);
        log.info("QuizListReply Register End");
        return entity.getQlrno();
    }

    @Override
    public List<QuizListReply> getList(long qlno){
        log.info("QuizListReply Page Build Start");
//        Pageable pageable = requestDTO.getPageable(Sort.by("qlrno").descending());
//        BooleanBuilder booleanBuilder = getSearch(requestDTO);
//        Page<QuizListReply> result = repository.findAll(booleanBuilder, pageable);
//        Function<QuizListReply, QuizListReplyDTO> fn = (entity->entityToDTO(entity));
        List<QuizListReply> quizListReply = repository.findAllByQlno(qlno);
        log.info("QuizListReply Page Build End");
        return quizListReply;
    }

    @Override
    public QuizListReplyDTO read(Long qlrno){
        log.info("QuizListReply Read Start");
        Optional<QuizListReply> result = repository.findById(qlrno);
        log.info("QuizListReply Read End");
        return result.isPresent() ? entityToDTO(result.get()) : null;
    }

    @Override
    public void modify(QuizListReplyDTO dto){
        log.info("QuizListReply Modify Start");
        Optional<QuizListReply> result = repository.findById(dto.getQlrno());

        if(result.isPresent()){
            QuizListReply entity = result.get();

            entity.changeContent(dto.getContent());

            log.info("QuizListReply Modify Success");
            repository.save(entity);
        }
        log.info("QuizListReply Modify End");
    }
}
