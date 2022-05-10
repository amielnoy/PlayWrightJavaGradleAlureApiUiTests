package users;

public class UsersManagement {
    private User user;

    public UsersManagement(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
