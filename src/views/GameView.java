package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameView extends JPanel {

    private ImageIcon puzzle;
    private JButton[] numPad = new JButton[10];
    private JLabel gameState, lifeLine;

    public GameView() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new FlowLayout());

        var gamePanel = new JPanel();
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
        populateGamePanel(gamePanel);
        add(gamePanel);

        var infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        populateInfoPanel(infoPanel);
        add(infoPanel);
    }

    private void populateGamePanel(JPanel parent) {
        puzzle = new ImageIcon();
        var puzzleContainer = new JLabel(puzzle);
        puzzleContainer.setSize(new Dimension(MainWindow.widthFactor(0.5), MainWindow.heightFactor(0.7)));
        parent.add(puzzleContainer);

        var statusPanel = new JPanel();
        statusPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));

        lifeLine = new JLabel();
        lifeLine.setFont(new Font("Serif", Font.BOLD, 15));
        statusPanel.add(lifeLine);

        gameState = new JLabel();
        gameState.setFont(new Font("Serif", Font.BOLD, 15));
        statusPanel.add(gameState);
        parent.add(statusPanel);

        // add solution buttons
        var solutionPad = new JPanel();
        solutionPad.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        for (var i = 0; i < numPad.length; ++i) {
            var btn = new JButton(String.valueOf(i));
            btn.setFont(new Font("Serif", Font.BOLD, 15));
            solutionPad.add(btn);
        }

        parent.add(solutionPad);
    }

    private void populateInfoPanel(JPanel parent) {

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
        // change the puzzle and disable all the buttons

    }

    public void setPuzzle(BufferedImage image) {
        this.puzzle.setImage(image);
        this.repaint();
    }
}
