package controller;

import dao.QuestionDAO;
import model.Question;

import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionController {
    private QuestionDAO questionDAO = new QuestionDAO();

    public QuestionController() throws SQLException, ClassNotFoundException {
    }

    public boolean addQuestion(String title, int option_1, int option_2, int option_3, int option_4, int correct_index) throws SQLException, ClassNotFoundException {
        Question question = new Question(title, option_1, option_2, option_3, option_4, correct_index);
        return questionDAO.insertQuestion(question);
    }

    public ArrayList<Question> getAllQuestions(){
        return questionDAO.getAllQuestions();
    }
}

