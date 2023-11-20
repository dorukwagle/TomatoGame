package controllers;

import views.GameView;

public class GameController {
    public GameController(GameView view, Runnable onLogOut) {
        view.getLogOutBtn().addActionListener(e -> onLogOut.run());
    }
}
