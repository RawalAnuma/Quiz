package view;

import model.Question;

import java.util.ArrayList;
import java.util.Scanner;

import static controller.QuestionController.questionService;

public class UpdateQuestionView {
    public static void showUpdateQuestionView() {
        Scanner scanner = new Scanner(System.in);
        try{
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
            System.out.println("Enter the question number you want to update: ");
            int questionNumber = Integer.parseInt(scanner.nextLine());

            if(questionNumber < 1 || questionNumber > questions.size() ){
                System.out.println("Enter a valid question number");
                return;
            }

            Question oldQuestion = questions.get(questionNumber - 1);
            System.out.println("Updating question: " + oldQuestion.getTitle());

            System.out.println("Enter new title: ");
            String title = scanner.nextLine();

            System.out.println("Enter new option 1: ");
            int option1 = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter new option 2: ");
            int option2 = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter new option 3: ");
            int option3 = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter new option 4: ");
            int option4 = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter correct option number: ");
            int correctIndex = Integer.parseInt(scanner.nextLine());

            if(correctIndex < 1 || correctIndex > 4){
                System.out.println("Make sure correct option is between 1 & 4!");
                return;
            }

            Question updatedQuestion = new Question(title, option1, option2, option3, option4, correctIndex);
            boolean updated = questionService.updateQuestion(questionNumber, updatedQuestion);
            if(updated){
                System.out.println("Question has been updated");
            }else{
                System.out.println("Failed to update question");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
