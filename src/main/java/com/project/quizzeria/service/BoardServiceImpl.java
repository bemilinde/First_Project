package com.project.quizzeria.service;

import com.project.quizzeria.dto.BoardDTO;
import com.project.quizzeria.dto.PageRequestDTO;
import com.project.quizzeria.dto.PageResultDTO;
import com.project.quizzeria.entity.Board;
import com.project.quizzeria.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;

    @Override
    public Long register(BoardDTO dto) {
        log.info("Board Register Start");
        Board entity = dtoToEntity(dto);
        repository.save(entity);
        log.info("Board Register End");
        return entity.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO){
        log.info("Board Page Build Start");
        Pageable pageable = requestDTO.getPageable(Sort.by("bno").descending());
        Page<Board> result = repository.findAll(pageable);
        Function<Board, BoardDTO> fn = (entity->entityToDTO(entity));
        log.info("Board Page Build End");
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public List<Board> getListHome(){
       List<Board> boardList = repository.findAll();
       Collections.reverse(boardList);

       List<Board> result = new ArrayList<>();
       IntStream.rangeClosed(0, 5).forEach(i->{
           result.add(boardList.get(i));
       });

        return result;
    }

    @Override
    public BoardDTO read(Long bno) {
        log.info("Board Read Start");
        Optional<Board> result = repository.findById(bno);
        if (result.isPresent()) {
            Board board = result.get();
            board.increaseViews(); // 조회수 증가
            repository.save(board); // 변경된 조회수를 저장
            log.info("Board Read End");
            return entityToDTO(board);
        }
        return null;
    }

    @Override
    public void modify(BoardDTO dto){
        log.info("Board Modify Start");
        Optional<Board> result = repository.findById(dto.getBno());

        if(result.isPresent()){
            Board entity = result.get();

            entity.changeContent(dto.getContent());
            entity.changeTitle(dto.getTitle());

            log.info("Board Modify Success");
            repository.save(entity);
        }
        log.info("Board Modify End");
    }

    @Override
    public void delete(Long bno) {
        log.info("Board Delete Start");
        repository.deleteById(bno);
        log.info("Board Delete End");
    }

    @Transactional
    @Override
    public void increaseLikes(Long bno) {
        Optional<Board> optionalBoard = repository.findById(bno);
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            board.increaseLikes();
        }
    }

}