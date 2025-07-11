package controller;

import model.Question;
import model.ScoreBoard;
import model.User;
import service.QuestionService;
import view.AddQuestionView;
import view.DeleteQuestionView;
import view.UpdateQuestionView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionController {
    public static final QuestionService questionService;

    static {
        try {
            questionService = new QuestionService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean startQuiz(User user) {
        boolean isGameEnded = false;
        ScoreController scoreController = new ScoreController();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> quizList = questionService.getAllQuestions();
        int i = 1;
        int score = 0;
        for (Question question : quizList) {
            System.out.println("Question " + i + ": " + question.getTitle() + "\n");
            System.out.println("1. " + question.getOptions()[0]);
            System.out.println("2. " + question.getOptions()[1]);
            System.out.println("3. " + question.getOptions()[2]);
            System.out.println("4. " + question.getOptions()[3]);
            System.out.print("Your answer (1-4): ");

            int userAnswer = scanner.nextInt();
            if (userAnswer == question.getCorrect_index()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is option " + question.getCorrect_index());
            }
            i++;
        }
        ScoreBoard scoreBoard = new ScoreBoard(user.getUserId(),score);
        isGameEnded = scoreController.keepScore(scoreBoard);
        return isGameEnded;
    }


    public void listQuestions(){
        ArrayList<Question> quizQuestion = questionService.getAllQuestions();
        int i = 1;
        for(Question ques: quizQuestion){
            System.out.println("Question " + i + ": " + ques.getTitle());
            ques.showOptions();
            System.out.println("Correct option is "+ ques.getCorrect_index());
            i++;
        }

    }

    public void createQuestion() {
        AddQuestionView.showAddQuestionView();
    }

    public void updateQuestion() {
        UpdateQuestionView.showUpdateQuestionView();
    }

    public void deleteQuestion(){
        DeleteQuestionView.showDeleteQuestionView();

    }
}

