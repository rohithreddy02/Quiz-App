package com.project.quizapp.Service;

import com.project.quizapp.Dao.QuestionDao;
import com.project.quizapp.Dao.QuizDao;
import com.project.quizapp.Model.Question;
import com.project.quizapp.Model.QuestionWapper;
import com.project.quizapp.Model.Quiz;
import com.project.quizapp.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("sucess", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionDB= quiz.get().getQuestions();
        List<QuestionWapper> questionForUser=new ArrayList<>();
        for(Question q:questionDB){
            QuestionWapper qw=new QuestionWapper(q.getId(), q.getQuestion_title(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses){
        Quiz quiz=quizDao.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response response: responses){
            if(response.getResponse().equals(questions.get(i).getRight_answer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }

}
