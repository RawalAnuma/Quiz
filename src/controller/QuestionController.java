package controller;

import dao.QuestionDAO;
import model.Question;
import service.QuestionService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionController {
    private static final QuestionService questionService;

    static {
        try {
            questionService = new QuestionService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> quizList = questionService.getAllQuestions();
        int i = 1;
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
            } else {
                System.out.println("Wrong! The correct answer is option " + question.getCorrect_index());
            }
            i++;
        }
    }


    public static void listQuestions(){
        ArrayList<Question> quizQuestion = questionService.getAllQuestions();
        int questionIndex = 1;
        for(Question ques: quizQuestion){
            System.out.println("Question " + questionIndex + ": " + ques.getTitle());
            ques.showOptions();
            System.out.println(ques.getCorrect_index());
        }
    }
}

