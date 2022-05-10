package services.Auth;

import com.google.gson.Gson;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import models.Auth.User;
import models.Auth.UserManagement;
import utils.StringUtils;

public class UserService {
    public static final String CREATE_USER_ENDPOINT = "/api/users";
    public static final String AUTH_LOGIN_ENDPOINT = "/api/users/login";

    public User createNewRandomUser(APIRequestContext request) {
        User newUser = new UserService().getRandomUser();
        UserManagement userManagement1 = new UserManagement(newUser);
        APIResponse createUser = request.post(CREATE_USER_ENDPOINT,
                RequestOptions.create().setData(userManagement1));
        System.out.println("USER IS: \n" + createUser.text());
        UserManagement userManagement = new Gson().fromJson(createUser.text(), UserManagement.class);
        return userManagement.getUser();
    }

    public User getRandomUser() {
        String randomString = new StringUtils().generateRandomAlphanumeric(10);
        String email = randomString + "@test.com";
        String password = "password";
        String userName = randomString;
        models.Auth.User newUser = new models.Auth.User(email, password);
        newUser.setUsername(userName);
        return newUser;
    }
}
