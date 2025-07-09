package view;

import controller.QuestionController;

import java.sql.SQLException;
import java.util.Scanner;

public class PlayerView {
   public static void gameStart() {
       Scanner input = new Scanner(System.in);
       QuestionController questionController = new QuestionController();
       int option = 0;
       System.out.println("Enter 1: Start Game");
       System.out.println("Enter 2: View scoreboard");
       System.out.println("Enter 3: Exit");
       System.out.println("Enter your choice: ");
       option = Integer.parseInt(input.nextLine());

       if(option >0){
           if(option == 1) {

           } else if(option == 2) {
               try {
                   System.out.println("Viewing scoreboard...");
               } catch (Exception e) {
                   System.out.println("An error occurred while viewing the scoreboard: " + e.getMessage());
               }
           } else if(option == 3) {
               System.out.println("Exiting the game. Thank you for playing!");
           } else {
               System.out.println("Invalid option. Please try again.");
           }
       }

   }
}
