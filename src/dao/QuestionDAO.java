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
                String query = "INSERT INTO questions (title, option1, option2, option3, option4, correctOption ) VALUES (?, ?, ?, ?, ?, ?)";
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
        String query = "SELECT title, option1, option2, option3, option4, correctOption FROM questions";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet questionSet = ps.executeQuery();
            while (questionSet.next()) {
                String title = questionSet.getString("title");
                int option1 = questionSet.getInt("option1");
                int option2 = questionSet.getInt("option2");
                int option3 = questionSet.getInt("option3");
                int option4 = questionSet.getInt("option4");
                int correctOption = questionSet.getInt("correctOption");
                Question question = new Question(title, option1, option2, option3, option4, correctOption);
                questions.add(question);
            }
            return questions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateQuestion(int questionid, Question question) {
        boolean isUpdated = false;
        try {
            String query = "UPDATE questions SET title = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ?, correctOption = ? WHERE questionid = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, question.getTitle());
            ps.setInt(2, question.getOptions()[0]);
            ps.setInt(3, question.getOptions()[1]);
            ps.setInt(4, question.getOptions()[2]);
            ps.setInt(5, question.getOptions()[3]);
            ps.setInt(6, question.getCorrect_index());
            ps.setInt(7, questionid);
            int row = ps.executeUpdate();
            if (row > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    public boolean deleteQuestion(int questionid) {
        boolean isDeleted = false;
        try {
            String query = "DELETE FROM questions WHERE questionid = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, questionid);
            int row = ps.executeUpdate();
            if (row > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }
}
