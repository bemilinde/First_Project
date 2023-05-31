package com.project.quizzeria.entity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EntityListeners(value = { AuditingEntityListener.class })
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String question;

    @ElementCollection
    @CollectionTable(name = "quiz_choices", joinColumns = @JoinColumn(name = "quiz_id"))
    @Column(name = "choice")
    private List<String> choices = new ArrayList<>();

    @Column(nullable = false)
    private String answer;

    @Builder
    public Quiz(Long qno, Member member, String title, String question, List<String> choices, String answer){
        this.qno = qno;
        this.member = member;
        this.title = title;
        this.question = question;
        this.choices = choices;
        this.answer = answer;
    }

}
