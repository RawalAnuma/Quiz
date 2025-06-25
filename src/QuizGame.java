import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Question question1 = new Question("What is my age?",20 , 29, 35, 40, 1);
        Scanner scanner = new Scanner(System.in);


        while(true){
            System.out.println("Question: " + question1.getTitle());
            System.out.println("1. " + question1.getOption1());
            System.out.println("2. " + question1.getOption2());
            System.out.println("3. " + question1.getOption3());
            System.out.println("4. " + question1.getOption4());
            System.out.print("Please enter your answer (1-4): ");

            int userAnswer = scanner.nextInt();

            if (question1.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                break; // Exit the loop if the answer is correct
            } else {
                System.out.println("Incorrect, please try again.");
            }
        }
    }
}
