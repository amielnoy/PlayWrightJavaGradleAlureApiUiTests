package services.Auth;

import com.google.gson.Gson;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.options.RequestOptions;
import models.Auth.User;
import models.Auth.UserManagement;
import utils.StringUtils;

public class UserService {
    public static final String CREATE_USER_ENDPOINT = "/api/users";
    public static final String CURRENT_USER_ENDPOINT = "/api/user";
    public static final String AUTH_LOGIN_ENDPOINT = "/api/users/login";

    public APIResponse createUser(APIRequestContext request, User user /*users req fields are email, password and username*/){
        UserManagement userManagement1 = new UserManagement(user);
        return request.post(CREATE_USER_ENDPOINT,
                RequestOptions.create().setData(userManagement1));
    }

    public APIResponse logInUser(APIRequestContext request, User user){
        return request.post(AUTH_LOGIN_ENDPOINT,
                RequestOptions.create().setData(new UserManagement(user)));
    }

    public String getAuthToken(APIRequestContext request, User user){
        APIResponse response = request.post(AUTH_LOGIN_ENDPOINT,
                RequestOptions.create().setData(new UserManagement(user)));
        return new Gson().fromJson(response.text(), UserManagement.class).getUser().getToken();
    }

    public APIResponse getCurrentUser(APIRequestContext request, String token){
        return request.get(CURRENT_USER_ENDPOINT,
                RequestOptions.create().setHeader("Authorization", "Token "+token));
    }

    public User createNewRandomUser(APIRequestContext request) throws Exception {
        User newUser = new UserService().generateRandomUserDetails();
        APIResponse createUserResponse = createUser(request, newUser);
        System.out.println("USER IS: \n" + createUserResponse.text());
        if (createUserResponse.ok()){
            UserManagement userManagement = new Gson().fromJson(createUserResponse.text(), UserManagement.class);
            return userManagement.getUser();
        } else {
            throw new Exception("Fail to create user");
        }
    }

    public User generateRandomUserDetails() {
        String randomString = new StringUtils().generateRandomAlphanumeric(10);
        String email = randomString + "@test.com";
        String password = "password";
        String userName = randomString;
        models.Auth.User newUser = new models.Auth.User(email, password);
        newUser.setUsername(userName);
        return newUser;
    }
}
