package controllers;

import DTO.User;
import views.GameView;
import views.LoginPage;
import views.MainWindow;

public class WindowController {
    private MainWindow window;

    public WindowController() {
        this.window = MainWindow.getInstance();
        initLogin();
    }

    private void initLogin() {
        var loginPage = new LoginPage();
        window.setContent(loginPage);
        new LoginController(loginPage, this::initGame);
    }

    private void initGame(User user) {
        var gameView = new GameView();
        new GameController(gameView, this::initLogin);
        window.setContent(gameView);
    }
}
