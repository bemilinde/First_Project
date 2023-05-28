package com.project.quizzeria.service;

import com.project.quizzeria.dto.PageRequestDTO;
import com.project.quizzeria.dto.PageResultDTO;
import com.project.quizzeria.dto.QuizListDTO;
import com.project.quizzeria.entity.QuizList;
import com.project.quizzeria.repository.QuizListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuizListServiceImpl implements QuizListService{

    private final QuizListRepository repository;

    @Override
    public Long register(QuizListDTO dto) {
        log.info("QuizList Register Start");
        QuizList entity = dtoToEntity(dto);
        repository.save(entity);
        log.info("QuizList Register End");
        return entity.getQlno();
    }

    @Override
    public PageResultDTO<QuizListDTO, QuizList> getList(PageRequestDTO requestDTO){
        log.info("QuizList Page Build Start");
        Pageable pageable = requestDTO.getPageable(Sort.by("qlno").descending());
        Page<QuizList> result = repository.findAll(pageable);
        Function<QuizList, QuizListDTO> fn = (entity->entityToDTO(entity));
        log.info("QuizList Page Build End");
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public QuizListDTO read(Long qlno){
        log.info("QuizList Read Start");
        Optional<QuizList> result = repository.findById(qlno);
        log.info("QuizList Read End");
        return result.isPresent() ? entityToDTO(result.get()) : null;
    }

    @Override
    public void modify(QuizListDTO dto){
        log.info("QuizList Modify Start");
        Optional<QuizList> result = repository.findById(dto.getQlno());

        if(result.isPresent()){
            QuizList entity = result.get();

            entity.changeTitle(dto.getTitle());

            log.info("QuizList Modify Success");
            repository.save(entity);
        }
        log.info("QuizList Modify End");
    }

}
