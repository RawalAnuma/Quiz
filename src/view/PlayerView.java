package view;

import controller.QuestionController;
import controller.ScoreController;
import model.ScoreBoard;
import model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class PlayerView {
   public static void gameStart(User user) {
       Scanner input = new Scanner(System.in);
       QuestionController questionController = new QuestionController();
       ScoreController scoreController = new ScoreController();
       while(true) {
           int option = 0;
           System.out.println("Enter 1: Start Game");
           System.out.println("Enter 2: View scoreboard");
           System.out.println("Enter 3: Exit");
           System.out.println("Enter your choice: ");

           try {
               option = Integer.parseInt(input.nextLine());
               switch (option){
                     case 1:
                          System.out.println("Starting the game...");
                          questionController.startQuiz(user);
                          break;
                     case 2:
                          System.out.println("Viewing the scoreboard...");
                          scoreController.showScoreBoard();
                          break;
                     case 3:
                          System.out.println("Exiting the game. Thank you for playing!");
                          return;
                     default:
                          System.out.println("Invalid option. Please try again.");
               }

           } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
           }
       }

   }
}
