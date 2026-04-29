package entities.user;

public class UserSender implements User {
    private int userId;
    private String userName;
    public UserSender(int userId,String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public void pushNotificationRequest(){
        //todo
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
