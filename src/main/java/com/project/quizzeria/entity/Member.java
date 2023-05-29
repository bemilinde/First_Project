package com.project.quizzeria.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity implements UserDetails {

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

    @ColumnDefault("'N'")
    @Column(length = 10, nullable = false)
    private String hidden;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Quiz> quizzes = new ArrayList<>();

    @Builder
    public Member(Long mno, String id, String password, String email, String name, int age, String job, String tel, String addr, String auth, String hidden) {
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
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
