package controllers;

import DTO.User;
import models.RegistrationModel;
import views.RegistrationPage;

import java.awt.*;

public class RegistrationController {
    public RegistrationController(RegistrationPage view, Runnable login) {
        view.getLoginBtn().addActionListener(e -> login.run());

        var fullName = view.getFullName();
        var username = view.getUsername();
        var password = view.getPassword();
        var confPassword = view.getConfirmPassword();
        var msg = view.getErrMsg();

        view.getRegisterBtn().addActionListener(e -> {
            if (!password.getText().equals(confPassword.getText())) {
                msg.setForeground(Color.RED);
                msg.setText("passwords do not match");
            }
            User user = new User(fullName.getText(), username.getText(), password.getText());
            var registered = new RegistrationModel().registerUser(user);
            if (registered) {
                msg.setForeground(Color.green);
                msg.setText("Registered successfully! please login");
            }
        });
    }
}
