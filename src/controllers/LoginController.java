package controllers;

import views.LoginPage;

public class LoginController {
    private Runnable onLoginSuccess;

    public LoginController(LoginPage view, Runnable onLoginSuccess) {
        this.onLoginSuccess = onLoginSuccess;

        view.getLoginBtn().addActionListener(e -> onLoginSuccess.run());
    }
}
