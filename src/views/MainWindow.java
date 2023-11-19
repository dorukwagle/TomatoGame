package views;


import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private static final double WINDOW_SIZE = 0.7;
    private static Dimension dimension;
    private static Container basePanel;
    private static MainWindow window;
    private JFrame frame;

    private MainWindow() {
        // get screen size
        var screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

        // create new dimension for main window
        var frameDimension = dimension = new Dimension((int)(screenDimension.getWidth() * WINDOW_SIZE),
                (int)(screenDimension.getHeight() * WINDOW_SIZE));

        frame = new JFrame("TomatoGame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(frameDimension);
        frame.setResizable(false);

        basePanel = frame.getContentPane();

        frame.setVisible(true);
    }

    public static MainWindow getInstance() {
        return window != null ? window : (window = new MainWindow());
    }

    public static int widthFactor(double factor) {
        return (int) (dimension.getWidth() * factor);
    }

    public static int heightFactor(double factor) {
        return (int) (dimension.getHeight() * factor);
    }

    public void pack() {
        frame.pack();
    }

    public void setContent(Component content) {
        basePanel.removeAll();
        basePanel.add(content);
        basePanel.repaint();
        basePanel.revalidate();
    }
}
