package model;

import java.sql.Timestamp;

public class ScoreBoard {
    private int userId;
    private int score;
    private Timestamp playedDate;

    public ScoreBoard( int userId, int score) {
        this.userId = userId;
        this.score = score;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Timestamp getPlayedDate() {
        return playedDate;
    }
    public void setPlayedDate(Timestamp playedDate) {
        this.playedDate = playedDate;
    }

}
