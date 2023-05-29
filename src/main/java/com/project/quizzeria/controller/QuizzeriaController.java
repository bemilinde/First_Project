package com.project.quizzeria.controller;

import com.project.quizzeria.dto.PageRequestDTO;
import com.project.quizzeria.dto.QuizDTO;
import com.project.quizzeria.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/main")
@RequiredArgsConstructor
public class QuizzeriaController {
    private final BoardService boardService;
    private final QuizService quizService;
    @GetMapping("/welcome")
    public void Main() {
        log.info("Quizzeria_Main In");
    }

    @GetMapping("/home")
    public void Home(Model model) {
        QuizDTO randomQuiz = quizService.getRandomQuiz();
        model.addAttribute("quiz", randomQuiz);
        log.info("Quizzeria_Home In");
        model.addAttribute("board", boardService.getListHome());
    }


}
