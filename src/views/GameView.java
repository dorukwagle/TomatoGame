package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class GameView extends JPanel {

    private JLabel puzzleContainer;
    private JButton[] numPad = new JButton[10];
    private JLabel gameState, lifeLine, gameScore;
    private JButton logOutBtn, resetBtn;

    public GameView() {
        setBorder(new EmptyBorder(20, 10, 20, 10));
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;

        var gamePanel = new JPanel();
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.PAGE_AXIS));
        populateGamePanel(gamePanel);
        constraints.weightx = 0.5;
        constraints.gridx = 0;

        add(gamePanel, constraints);

        var infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        populateInfoPanel(infoPanel);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        add(infoPanel, constraints);
    }

    private void populateGamePanel(JPanel parent) {

        puzzleContainer = new JLabel();
        puzzleContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
        puzzleContainer.setBackground(Color.blue);

        parent.add(puzzleContainer);

        var stateHolder = new JPanel();
        stateHolder.setLayout(new FlowLayout(FlowLayout.LEFT));
        gameState = new JLabel("Guess Hidden Number!");
        gameState.setFont(new Font("Serif", Font.BOLD, 20));

        stateHolder.add(gameState);
        parent.add(createSpace());
        parent.add(stateHolder);

        // add solution buttons
        var solutionPad = new JPanel();
        solutionPad.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        for (var i = 0; i < numPad.length; ++i) {
            var btn = numPad[i] = new JButton(String.valueOf(i));
            btn.setFont(new Font("Serif", Font.BOLD, 15));
            solutionPad.add(btn);
        }

        parent.add(createSpace());
        parent.add(solutionPad);
    }

    private void populateInfoPanel(JPanel parent) {
        var playerName = new JLabel("Player: Test Player");
        playerName.setFont(new Font("Serif", Font.BOLD, 25));
        parent.add(playerName);

        parent.add(createSpace());

        gameScore = new JLabel("Score: 0");
        gameScore.setFont(new Font("Serif", Font.BOLD, 20));
        parent.add(gameScore);

        lifeLine = new JLabel("Lives: ");
        lifeLine.setFont(new Font("Serif", Font.BOLD, 20));
        parent.add(lifeLine);

        parent.add(createSpace());

        var controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        resetBtn = new JButton("Reset Game");
        resetBtn.setFont(new Font("Serif", Font.BOLD, 20));
        parent.add(resetBtn);

        parent.add(createSpace());

        logOutBtn = new JButton("Log Out");
        logOutBtn.setFont(new Font("Serif", Font.BOLD, 20));
        parent.add(logOutBtn);

        parent.add(controlPanel);
    }

    private Component createSpace() {
        return Box.createRigidArea(new Dimension(5, 20));
    }

    public void setLifeLine(int lifeLines) {
        this.lifeLine.setText(String.valueOf(lifeLines));
    }

    public void alertLevelPass() {
        this.gameState.setForeground(Color.GREEN);
        this.gameState.setText("Level Passed: Score (+1)");
    }

    public void alertLevelFailed() {
        this.gameState.setForeground(Color.RED);
        this.gameState.setText("Level Failed: Score (-1)");
    }

    public void alertIncorrectGuess() {
        this.gameState.setForeground(Color.RED);
        this.gameState.setText("Incorrect Guess!!");
    }

    public void alertGameOver() {
        // disable all the buttons
        Arrays.stream(numPad).forEach(btn -> btn.setEnabled(false));
    }

    public void resetGame() {
        // enable all the buttons
        Arrays.stream(numPad).forEach(btn -> btn.setEnabled(true));
    }

    public void setPuzzle(BufferedImage image) {
        var icon = new ImageIcon(image.getScaledInstance(MainWindow.widthFactor(0.7),
                MainWindow.heightFactor(0.7), Image.SCALE_SMOOTH));
        this.puzzleContainer.setIcon(icon);
        this.repaint();
    }

    public void setGameScore(int score) {
        this.gameScore.setText(String.valueOf(score));
    }

    public JButton[] getNumPad() {
        return numPad;
    }

    public JButton getLogOutBtn() {
        return logOutBtn;
    }

    public JButton getResetBtn() {
        return resetBtn;
    }
}
