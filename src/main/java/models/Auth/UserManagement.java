package models.Auth;

public class UserManagement {
    private User user;

    public UserManagement(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
