package view;
import controller.UserController;

import java.util.Scanner;

public class GameMenu {
    public static void showMenu() {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Are you ready for the Quiz Game!");
            System.out.println("Please choose an option:");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            int option = Integer.parseInt(scan.nextLine());
            if (option == 1) {
                SignUpView.showSignUpView();

            } else if (option == 2) {
                LoginView.showLoginView();

            } else if( option == 3) {
                System.out.println("Thank you for playing! Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

    }
}
