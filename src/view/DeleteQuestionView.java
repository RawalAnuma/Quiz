package view;

import dao.QuestionDAO;
import model.Question;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static controller.QuestionController.questionService;

public class DeleteQuestionView {
    public static void showDeleteQuestionView() {
        Scanner scanner = new Scanner(System.in);
        try {
            ArrayList<Question> questions = questionService.getAllQuestions();

            if(questions.isEmpty()){
                System.out.println("No questions available.");
                return;
            }
            int index = 1;
            for(Question que: questions){
                System.out.println(index + "." + que.getTitle());
                index++;
            }
            System.out.println("Enter the question ID to delete: ");
            int questionId = Integer.parseInt(scanner.nextLine());

            QuestionDAO questionDAO = new QuestionDAO();
            boolean isDeleted = questionDAO.deleteQuestion(questionId);
            if (isDeleted) {
                System.out.println("Question deleted successfully.");
            } else {
                System.out.println("Failed to delete question. Please check the ID and try again.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("An error occurred while deleting the question: " + e.getMessage());
        }
        System.out.println("Question deleted successfully!"); // Placeholder for actual deletion logic
    }
}
