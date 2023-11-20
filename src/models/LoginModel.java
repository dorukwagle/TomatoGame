package models;

import controllers.LoginController;

import java.util.HashMap;
import java.util.Map;

public class LoginModel {
    private final Map<String, String> users = new HashMap<>();

    public LoginModel() {
        // create a list of users
        users.putAll(Map.of(
                "Aashika", "rai",
                "Shallona", "shallona",
                "Doruk", "doruk"
        ));
    }

    public boolean verifyUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
