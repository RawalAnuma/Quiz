package view;

import model.User;

import java.util.Scanner;

public class GameMasterView {
    public static void show(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Game Master View!");
        System.out.println("1. Create a new question");
        System.out.println("2. View existing questions");
        System.out.println("3. Delete a question");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

        if(choice == 2){
            QuizView.showQuiz();
        }

    }
}
