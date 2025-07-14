package dao;

import model.ScoreBoard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ScoreDAO {
    private Connection conn;
    public ScoreDAO(){
        try {
            conn = DatabaseConnection.connect();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insertScore(int userId, int score) {
        String query = "INSERT INTO scoreboard (userid, score, playedDate) VALUES (?, ?, NOW())";
        try {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, userId);
                ps.setInt(2, score);
                return ps.executeUpdate() > 0;
            }

        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public List <ScoreBoard> getAllScores(){
        List<ScoreBoard> scoreList = new ArrayList<>();
        String query = "SELECT * FROM scoreboard";
        try {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int userId = rs.getInt("userid");
                    int score = rs.getInt("score");
                    Timestamp playedDate = rs.getTimestamp("playedDate");
                    ScoreBoard scoreBoard = new ScoreBoard(userId, score);
                    scoreList.add(scoreBoard);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return scoreList;
    }





}
