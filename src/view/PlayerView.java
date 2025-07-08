package view;

import controller.QuestionController;
import model.Question;

import java.util.ArrayList;

public class PlayerView {
    public static void gameStart(){
        QuestionController questionController = new QuestionController();
        ArrayList<Question> quizList = questionController.getQuestions();
    }
}
