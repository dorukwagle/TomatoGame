package controllers;

import DTO.User;
import models.GameModel;
import views.GameView;
import views.MainWindow;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class GameController {
    private final int MAX_LIVES = 3;
    private GameView view;

    public GameController(GameView view, User player, Runnable onLogOut) {
        this.view = view;

        Arrays.stream(view.getNumPad())
                .forEach(btn -> btn.addActionListener(e -> onSolutionBtnPressed(btn)));

        view.getResetBtn().addActionListener(e -> {
            GameView gameView;
            MainWindow.getInstance().setContent((gameView = new GameView()));
            new GameController(gameView, player, onLogOut);
        });

        view.getLogOutBtn().addActionListener(e -> onLogOut.run());

        try {
            view.setPuzzle(new GameModel().getGameOverScreen());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void onSolutionBtnPressed(JButton btn) {

    }
}
