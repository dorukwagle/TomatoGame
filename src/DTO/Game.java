package DTO;

import java.awt.image.BufferedImage;

public class Game {
    private BufferedImage puzzle;
    private int solution;

    public Game(BufferedImage puzzle, int solution) {
        this.puzzle = puzzle;
        this.solution = solution;
    }

    public BufferedImage getPuzzle() {
        return puzzle;
    }

    public int getSolution() {
        return solution;
    }
}
