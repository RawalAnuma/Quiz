package view;

import controller.QuestionController;
import model.Question;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizView {
    public static void showQuiz(){
        QuestionController questionController;
        try {
            questionController = new QuestionController();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> quizList = questionController.getAllQuestions();
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
}
