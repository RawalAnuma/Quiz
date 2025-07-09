package view;

import controller.QuestionController;
import model.User;

import java.util.Scanner;

public class GameMasterView {
    public static void show(User user) {
        Scanner scanner = new Scanner(System.in);
        QuestionController questionController = new QuestionController();
        System.out.println("Welcome to the Game Master View!");
        System.out.println("1. Create a new question");
        System.out.println("2. Update an existing question");
        System.out.println("3. View Questions");
        System.out.println("4. Test existing questions");
        System.out.println("5. Log out");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        if(choice >0) {
            if (choice == 1) {
                questionController.createQuestion();
            } else if (choice == 2) {
                questionController.updateQuestion();

            } else if (choice == 3) {
                System.out.println("Viewing all questions...");
                questionController.listQuestions();
            } else if (choice == 4) {
                System.out.println("Testing existing questions...");
                 questionController.startQuiz();

            } else if (choice == 5) {
                System.out.println("Logging out...");
            } else {
                System.out.println("Invalid choice");
            }
        }else{
            System.out.println("Please enter choice(1-5)");
        }
    }
}
