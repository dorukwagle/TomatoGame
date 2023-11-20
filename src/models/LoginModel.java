package models;

import DTO.User;
import controllers.LoginController;

import java.util.HashMap;
import java.util.Map;

public class LoginModel {
    private final Map<String, User> users = new HashMap<>();

    public LoginModel() {
        // create a list of users
        users.putAll(Map.of(
                "Doruk",new User("Doruk Wagle", "Doruk", "doruk"),
                "Jessica", new User("Jessica Poudel", "Jessica", "jessica"),
                "Aashika", new User("Aashika Rai", "Aashika", "aashika")
        ));
    }

    public User verifyUser(String username, String password) {
        return users.containsKey(username) &&
                users.get(username).getPassword().equals(password)
                ?
                users.get(username) : null;
    }
}
