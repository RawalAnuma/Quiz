package model;

import java.time.LocalDate;

public class ScoreBoard {
    int scoreId;
    int userId;
    int score;
    private LocalDate playedDate;

    public ScoreBoard(int scoreId, int userId, int score, LocalDate playedDate) {
        this.scoreId = scoreId;
        this.userId = userId;
        this.score = score;
        this.playedDate = playedDate;
    }

}
