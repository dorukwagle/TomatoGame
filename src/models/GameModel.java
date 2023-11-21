package models;

import DTO.Game;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Base64;

public class GameModel {
    private final String url = "https://marcconrad.com/uob/tomato/api.php?out=csv&base64=yes";
    private int score;
    private int lives;

    public GameModel() {
        this.score = 0;
        this.lives = 3;
    }

    public Game getNewGame() throws IOException, InterruptedException {
        var res = fetchGame();
        if (res == null) return null;

        return new Game(
                base64ToImage(res[0]),
                Integer.parseInt(res[1])
        );
    }

    public BufferedImage getGameOverScreen() throws IOException {
        BufferedImage img =
                ImageIO.read(getClass().getClassLoader().getResource("res/gameover.png"));
        return img;
    }

    private String[] fetchGame() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response =
            HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response != null ? response.body().split(",") : null;
    }

    private BufferedImage base64ToImage(String base64) throws IOException{
        byte[] bytes = Base64.getDecoder().decode(base64);
        return ImageIO.read(new ByteArrayInputStream(bytes));
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
