
import java.util.ArrayList;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        //how do i let users to select options instead of giving the answers directly?
        //TODO contructor ma index chaine vanda dherai rakhda ko problem milauna xha
        int score = 0;
        boolean is_running = true;
        String player_name = "";//khelne player ko nam rakhne ho
        Question question_1 = new Question("When did i pass out?", 2017,2018,2020,2021,4);
        Question question_2 = new Question("What is my birth year?", 2007,2000,2010,1997,2);
        ArrayList<Question> quiz_questions = new ArrayList<>();
        quiz_questions.add(question_1);
        quiz_questions.add(question_2);
        Scanner scan = new Scanner(System.in);
        System.out.println("Are you ready for the quizzz!!");
        System.out.println("Enter your name: ");
        player_name = scan.nextLine();
        while(is_running){
            //how do we control while loop?
            for(Question question: quiz_questions){
                System.out.println(question.getTitle());
                question.showOptions();
                System.out.println("choose the answer");
                int answer = Integer.parseInt(scan.nextLine());
                //how to handle score?
                if(question.checkAnswer(answer)){
                    System.out.println("Answer milyo");
                    score++;
                }else{
                    System.out.println("Answer milena");
                }
            }
            System.out.println("So, " + player_name+"\n");
            System.out.println("You scored "+ score);

            while(true){
                System.out.println("Do you still want to play??Y/N");
                String continueGame = scan.nextLine();
                if(continueGame.equals("N")){
                    is_running = false;
                    break;
                }else if(continueGame.equals("Y")){
                    // how do i reset my score after i restart my game??
                    score = 0;
                    break;
                }else{
                    System.out.println("Invalid option");
                }
            }

        }
    }
}