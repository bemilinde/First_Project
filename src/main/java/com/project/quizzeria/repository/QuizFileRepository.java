package com.project.quizzeria.repository;

import com.project.quizzeria.entity.QuizFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizFileRepository extends JpaRepository<QuizFile, Long> {
}
