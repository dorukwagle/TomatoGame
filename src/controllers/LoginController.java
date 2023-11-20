package controllers;

import DTO.User;
import models.LoginModel;
import views.LoginPage;

import java.util.function.Consumer;

public class LoginController {
    private Consumer<User> onLoginSuccess;

    public LoginController(LoginPage view, Consumer<User> onLoginSuccess) {
        this.onLoginSuccess = onLoginSuccess;
        var model = new LoginModel();

        var username = view.getUsername();
        var password = view.getPassword();
        var errMsg = view.getErrMsg();

        view.getLoginBtn().addActionListener(e -> {
            var user = model.verifyUser(username.getText(), password.getText());

            if (user == null) {
                errMsg.setText("Incorrect Username or Password!");
                return;
            }

            onLoginSuccess.accept(user);
        });
    }

}
