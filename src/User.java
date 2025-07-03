public class User {
    private boolean isGameMaster;
    private String username;
    private String password;

    public User(String username, String password, boolean isGameMaster){
        this.username = username;
        this.password = password;
        this.isGameMaster = isGameMaster;
    }

}
