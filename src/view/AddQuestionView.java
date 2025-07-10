package view;

import java.sql.SQLException;
import java.util.Scanner;

import static controller.QuestionController.questionService;

public class AddQuestionView {
    public static void showAddQuestionView(){
        Scanner scanner = new Scanner(System.in);

        try {
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
}
