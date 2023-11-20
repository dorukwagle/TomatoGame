package controllers;

import DTO.User;
import views.GameView;
import views.MainWindow;

public class GameController {
    public GameController(GameView view, User player, Runnable onLogOut) {

        view.getResetBtn().addActionListener(e -> {
            GameView gameView;
            MainWindow.getInstance().setContent((gameView = new GameView()));
            new GameController(gameView, player, onLogOut);
        });

        view.getLogOutBtn().addActionListener(e -> onLogOut.run());
    }
}
