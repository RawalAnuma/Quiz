package view;

import controller.QuestionController;
import model.Question;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlayerView {
    public static void gameStart() throws SQLException, ClassNotFoundException {
        QuestionController questionController = new QuestionController();
        ArrayList<Question> quizList = questionController.getQuestions();
    }
}
