package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static javax.swing.text.html.HTML.Tag.SELECT;

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
        String query = "INSERT INTO scoreboard (userid, score) VALUES (?, ?)";
        try {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, userId);
                ps.setInt(2, score);
                return ps.executeUpdate() > 0;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void scores(){
        String query = "SELECT user.username, max(scoreboard.score)as totalscore, scoreboard.playedDate FROM `scoreboard` JOIN user ON user.userId = scoreboard.userId GROUP by user.username order by totalscore DESC";
    }
}
