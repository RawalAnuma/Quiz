package dao;

import model.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionDAO {
    private static Connection conn;
    public QuestionDAO() throws SQLException, ClassNotFoundException {
        conn = DatabaseConnection.connect();
    }
    public boolean insertQuestion(Question question) {
        boolean isInserted = false;
        try {
            if (conn != null) {
                String query = "INSERT INTO question (title, option_1, option_2, option_3, option_4, correct_index) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, question.getTitle());
                ps.setInt(2, question.getOptions()[0]);
                ps.setInt(3, question.getOptions()[1]);
                ps.setInt(4, question.getOptions()[2]);
                ps.setInt(5, question.getOptions()[3]);
                ps.setInt(6, question.getCorrect_index());
                int row = ps.executeUpdate();
                if (row > 0) {
                    isInserted = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isInserted;
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM question";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet questionSet = ps.executeQuery();
            while (questionSet.next()) {
                String title = questionSet.getString("title");
                int option1 = questionSet.getInt("option_1");
                int option2 = questionSet.getInt("option_2");
                int option3 = questionSet.getInt("option_3");
                int option4 = questionSet.getInt("option_4");
                int correctIndex = questionSet.getInt("correct_index");
                Question question = new Question(title, option1, option2, option3, option4, correctIndex);
                questions.add(question);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }

}
