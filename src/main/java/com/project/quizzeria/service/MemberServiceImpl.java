package com.project.quizzeria.service;

import com.project.quizzeria.dto.MemberDTO;
import com.project.quizzeria.entity.Member;
import com.project.quizzeria.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements UserDetailsService  {

    private final MemberRepository memberRepository;

    /**
     * Spring Security 필수 메소드 구현
     *
     * @param id
     * @return UserDetails
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */
    @Override
    public Member loadUserByUsername(String id) throws UsernameNotFoundException {
        return memberRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException((id)));
    }

    /**
     * 회원정보 저장
     *
     * @param memberDTO 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
    public Long save(MemberDTO memberDTO){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        memberDTO.setPassword(encoder.encode(memberDTO.getPassword()));

        return memberRepository.save(Member.builder()
                .id(memberDTO.getId())
                .password(memberDTO.getPassword())
                .email(memberDTO.getEmail())
                .name(memberDTO.getName())
                .age(memberDTO.getAge())
                .job(memberDTO.getJob())
                .tel(memberDTO.getTel())
                .addr(memberDTO.getAddr())
                .auth(memberDTO.getAuth())
                .hidden(memberDTO.getHidden())
                .build()).getMno();
    }
}
