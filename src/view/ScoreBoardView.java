package view;

import dao.ScoreDAO;
import model.ScoreBoard;

import java.util.List;

public class ScoreBoardView {
    public static void showScoreBoardView(){
        try{
            ScoreDAO scoreDAO = new ScoreDAO();
            List<ScoreBoard> scores = scoreDAO.getAllScores();
            if (scores.isEmpty()) {
                System.out.println("No scores available.");
            } else {
                System.out.println("\n---------- Score Board ----------");
                System.out.println("User ID     Score     Played Date");
                System.out.println("----------------------------------");
                for(ScoreBoard score: scores){
                    System.out.println(score.getUserId() + "         " + score.getScore() + "         " + score.getPlayedDate());
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
