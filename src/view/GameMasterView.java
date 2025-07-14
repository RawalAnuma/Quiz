package view;

import controller.QuestionController;
import model.User;

import java.util.Scanner;

public class GameMasterView {
    public static void show(User user) {
        Scanner scanner = new Scanner(System.in);
        QuestionController questionController = new QuestionController();
        System.out.println("Welcome to the Game Master View!");

        while(true) {
            System.out.println("1. Create a new question");
            System.out.println("2. Update an existing question");
            System.out.println("3. View Questions");
            System.out.println("4. Test existing questions");
            System.out.println("5. Delete a question");
            System.out.println("6. Log out");
            System.out.println("Enter your choice: ");

            try{
            int choice = Integer.parseInt(scanner.nextLine());
                switch(choice){
                    case 1:
                        questionController.createQuestion();
                        break;
                    case 2:
                        questionController.updateQuestion();
                        break;
                    case 3:
                        System.out.println("Viewing all questions...");
                        questionController.listQuestions();
                        break;
                    case 4:
                        System.out.println("Testing existing questions...");
                        questionController.startQuiz(user);
                        break;
                    case 5:
                        questionController.deleteQuestion();
                        break;
                    case 6:
                        System.out.println("Logging out...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
