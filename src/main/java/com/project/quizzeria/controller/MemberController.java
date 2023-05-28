package com.project.quizzeria.controller;

import com.project.quizzeria.dto.MemberDTO;
import com.project.quizzeria.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberServiceImpl memberService;

    @GetMapping("/member_register")
    public void register(){
    }

    @PostMapping("/member_register")
    public String register(MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "redirect:/member/member_login";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/member/member_login";
    }

    @GetMapping({"/member_Info", "/member_modify"})
    public void getInfo() {
        log.info("Member_Info 접속...");
    }











}
