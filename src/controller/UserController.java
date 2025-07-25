package controller;

import dao.UserDAO;
import model.User;
import view.GameMasterView;
import view.PlayerView;

import java.sql.SQLException;

public class UserController {
    private UserDAO userdao;

    {
        try {
            userdao = new UserDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean signUp(String username, String password){
        boolean isSignedUp = false;
        User user = new User(username, password);
        isSignedUp = userdao.insertUser(user);
        if(isSignedUp) {
            return true;
        }else{
            return false;
        }
    }
    public boolean logIn(String username, String password) throws SQLException, ClassNotFoundException {
        User user = userdao.checkUser(username, password);
        if(user != null){
            if(user.isGameMaster()){
                GameMasterView.show(user);
            }else{
                PlayerView.gameStart(user);
            }
            return true;
        }
        return false;
    }

}
