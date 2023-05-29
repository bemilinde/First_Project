package com.project.quizzeria.controller;

import com.project.quizzeria.dto.BoardDTO;
import com.project.quizzeria.dto.PageRequestDTO;
import com.project.quizzeria.dto.QuizDTO;
import com.project.quizzeria.entity.Member;
import com.project.quizzeria.repository.MemberRepository;
import com.project.quizzeria.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/quiz/quiz_main")
    public void quizMain(PageRequestDTO pageRequestDTO, Model model) {
        log.info("Quiz_main In");
        model.addAttribute("read", quizService.getQuiz(pageRequestDTO));
    }

//    @GetMapping({"/board/board_main"})
//    public void Board(PageRequestDTO pageRequestDTO, Model model) {
//        log.info("Quizzeria_Board In" + pageRequestDTO);
//        model.addAttribute("result", boardService.getList(pageRequestDTO));
//    }

    @GetMapping({"/quiz/quiz_create"})
    public void create(){
        log.info("quiz_create In");
    }
    @PostMapping({"/quiz/quiz_create"})
    public String createPost(QuizDTO dto, PageRequestDTO pageRequestDTO, Model model){
        log.info("dto..." + dto);
        Long qno = quizService.create(dto);
        log.info("BNO: " + qno);
        model.addAttribute("read", quizService.getQuiz(pageRequestDTO));
        return "/quiz/quiz_main";
    }



}

