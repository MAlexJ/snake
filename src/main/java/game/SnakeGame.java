package game;

import javax.swing.*;
import java.awt.*;

public class SnakeGame extends JPanel {

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGTH = 20;

    public SnakeGame() {

    }

    public void paint(Graphics graph) {
        graph.setColor(color(20, 20, 50));
        graph.fillRect(0, 0, WIDTH * SCALE, HEIGTH * SCALE);
        graph.setColor(color(250, 216, 0));

        for (int axisX = 0; axisX <= WIDTH * SCALE; axisX += SCALE) {
            graph.drawLine(axisX, 0, axisX, HEIGTH * SCALE);
        }

        for (int axisY = 0; axisY <= HEIGTH * SCALE; axisY += SCALE) {
            graph.drawLine(0, axisY, WIDTH * SCALE, axisY);
        }


    }

    public Color color(int r, int g, int b) {
        return new Color(r, g, b);
    }

    public static void main(String[] args) {

        // Constructs a new frame that is initially invisible.
        JFrame frame = new JFrame();

        // Sets the operation that will happen by default
        // when the user initiates a "close" on this frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets whether this frame is resizable by the user.
        frame.setResizable(false);

        // The method changes the geometry-related data.
        frame.setSize(WIDTH * SCALE+1, HEIGTH * SCALE+1);

        // Add JPanel (SnakeGame) to JFrame
        frame.add(new SnakeGame());

        // Sets the location of the window relative to the specified c
        // component according to the following scenarios.
        frame.setLocationRelativeTo(null);

        //Shows or hides this {@code Window} depending on the value of parameter
        frame.setVisible(true);

    }
}
