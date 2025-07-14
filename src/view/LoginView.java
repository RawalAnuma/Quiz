package view;

import controller.UserController;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginView {
    public static void showLoginView(){
        UserController userController = new UserController();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scan.nextLine();
        System.out.println("Enter password: ");
        String password = scan.nextLine();
        try {
            if(!userController.logIn(username, password)){
                System.out.println("Invalid username or password. Please try again.");
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //GameMenu.showMenu();

    }
}
