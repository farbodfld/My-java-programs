public class User {
    private String userName;
    private String passWord;
    private int Score;

    public User(String username , String password){
        this.userName = username;
        this.passWord = password;
        this.Score = 0;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setScore(int score) {
        this.Score = score;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public int getScore() {
        return this.Score;
    }
}
