import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        Question[] questions = new Question[6];
        questions[0] = new Question("How many vowels are there in the English alphabet?", 5, 6, 9, 8, 1);
        questions[1] = new Question("How many alphabets are there in the English language?", 24, 25, 26, 27, 3);
        questions[2] = new Question("How many continents are there in the world?", 5, 6, 7, 8, 2);
        questions[3] = new Question("How many planets are there in the solar system?", 7, 8, 9, 10, 2);
        questions[4] = new Question("What is the height of Mount Everest?", 8848, 8849, 8850, 8851, 1);
        questions[5] = new Question("What is the value of 4 * 5?", 19, 20, 21, 22, 2);

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            Question que = questions[i];
            System.out.println("Question " + (i + 1) + ": " + que.getTitle());
            System.out.println("1. " + que.getOption1());
            System.out.println("2. " + que.getOption2());
            System.out.println("3. " + que.getOption3());
            System.out.println("4. " + que.getOption4());
            System.out.print("Please enter your answer (1-4): ");

            int userAnswer = scanner.nextInt();

            if (que.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect, please try again.");
            }

            System.out.println("Final Score: " + score);
        }
    }
}
