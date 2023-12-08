package controllers;

import DTO.User;
import views.GameView;
import views.LoginPage;
import views.MainWindow;
import views.RegistrationPage;

public class WindowController {
    private MainWindow window;

    public WindowController() {
        this.window = MainWindow.getInstance();
        initLogin();
    }

    private void initLogin() {
        var loginPage = new LoginPage();
        window.setContent(loginPage);
        new LoginController(loginPage, this::initGame, this::openRegistrationPage);
    }

    private void openRegistrationPage() {
        var page = new RegistrationPage();
        new RegistrationController(page, this::initLogin);
        window.setContent(page);
    }

    private void initGame(User user) {
        var gameView = new GameView(user);
        new GameController(gameView, user, this::initLogin);
        window.setContent(gameView);
    }
}
