package controller;

import dao.ScoreDAO;
import model.ScoreBoard;
import view.ScoreBoardView;

public class ScoreController {
    public boolean keepScore(ScoreBoard scoreBoard) {
        try {
            ScoreDAO scoreDAO = new ScoreDAO();
            return scoreDAO.insertScore(scoreBoard.getUserId(), scoreBoard.getScore());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void showScoreBoard(){
        ScoreBoardView.showScoreBoardView();
    }
}
