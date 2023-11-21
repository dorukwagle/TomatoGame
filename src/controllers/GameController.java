package controllers;

import DTO.Game;
import DTO.User;
import models.GameModel;
import views.GameView;
import views.MainWindow;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class GameController {
    private GameView view;
    private GameModel model;
    private Game currentGame;

    public GameController(GameView view, User player, Runnable onLogOut) {
        this.view = view;
        this.model = new GameModel();

        Arrays.stream(view.getNumPad())
                .forEach(btn -> btn.addActionListener(e -> onSolutionBtnPressed(btn)));

        view.getResetBtn().addActionListener(e -> {
            GameView gameView;
            MainWindow.getInstance().setContent((gameView = new GameView(player)));
            new GameController(gameView, player, onLogOut);
        });

        view.getLogOutBtn().addActionListener(e -> onLogOut.run());

        startNewGame();
    }

    private void startNewGame() {
        this.view.setGameScore(model.getScore());
        this.model.resetLives();
        this.view.setLifeLine(model.getLives());

        try {
            this.currentGame = model.getNewGame();
            this.view.setPuzzle(this.currentGame.getPuzzle());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void displayGameOver() {
        try {
            view.setPuzzle(model.getGameOverScreen());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void onSolutionBtnPressed(JButton btn) {
        var num = Integer.parseInt(btn.getText());

        if (num == this.currentGame.getSolution()) onLevelPass();
        else onIncorrectGuess();

        if (this.model.getLives() == 0) onLevelFailed();
        if (this.model.getScore() < 0) onGameOver();
    }

    private void onLevelPass() {
        this.view.alertLevelPass();
        this.model.increaseScore();
        this.startNewGame();
    }

    private void onIncorrectGuess() {
        this.view.alertIncorrectGuess();
        this.model.decreaseLife();
        this.view.setLifeLine(this.model.getLives());
    }

    private void onLevelFailed() {
        this.view.alertLevelFailed();
        this.model.decreaseScore();
        this.startNewGame();
    }

    private void onGameOver() {
        this.displayGameOver();
        this.view.alertGameOver();
    }
}
