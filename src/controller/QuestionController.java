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
        int i = 1;
        for(Question ques: quizQuestion){
            System.out.println("Question " + i + ": " + ques.getTitle());
            ques.showOptions();
            System.out.println("Correct option is "+ ques.getCorrect_index());
            i++;
        }

    }

    public void createQuestion() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter question title: ");
            String title = scanner.nextLine();

            System.out.println("Enter option 1: ");
            int option1 = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter option 2: ");
            int option2 = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter option 3: ");
            int option3 = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter option 4: ");
            int option4 = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter correct option index (1-4): ");
            int correctIndex = Integer.parseInt(scanner.nextLine());

            if(correctIndex <1 || correctIndex > 4){
                System.out.println("Invalid option index. Please enter a number between 1 and 4");
            }else{
                boolean isAdded = questionService.addQuestion(title, option1, option2, option3, option4, correctIndex);
                if (isAdded) {
                    System.out.println("Question added successfully!");
                } else {
                    System.out.println("Failed to add question.");
                }
            }


        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateQuestion() {

    }
}

