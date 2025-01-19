package com.project.quizapp.Dao;

import com.project.quizapp.Model.Question;
import com.project.quizapp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz,Integer> {


}
