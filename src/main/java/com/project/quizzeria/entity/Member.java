package com.project.quizzeria.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(name = "id", length = 30, nullable = false, unique = true)
    private String id;

    @Column(name = "password", length = 2000, nullable = false)
    private String password;

    @Column(name = "auth")
    private String auth;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 3, nullable = false)
    private int age;

    @Column(length = 50)
    private String job;

    @Column(length = 20)
    private String tel;

    @Column(length = 50)
    private String addr;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @ColumnDefault("'N'")
    @Column(length = 10, nullable = false)
    private String hidden;

    @Builder
    public Member(Long mno, String id,String password, String email, String name, int age, String job, String tel, String addr, String auth, LocalDateTime regDate, String hidden){
        this.mno = mno;
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.job = job;
        this.tel = tel;
        this.addr = addr;
        this.auth = auth;
        this.regDate = regDate;
        this.hidden = hidden;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : auth.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    @Override
    public String getUsername() {
        return id;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {   // 계정 만료 여부 반환
        // 만료되었는지 확인하는 로직
        return true; // true -> 만료되지 않았음
    }
    @Override
    public boolean isAccountNonLocked() {   // 계정 잠금 여부 반환
        // 계정 잠금되었는지 확인하는 로직
        return true; // true -> 잠금되지 않았음
    }
    @Override
    public boolean isCredentialsNonExpired() {  // 패스워드의 만료 여부 반환
        // 패스워드가 만료되었는지 확인하는 로직
        return true; // true -> 만료되지 않았음
    }
    @Override
    public boolean isEnabled() {    // 계정 사용 가능 여부 반환
        // 계정이 사용 가능한지 확인하는 로직
        return true; // true -> 사용 가능
    }

}
