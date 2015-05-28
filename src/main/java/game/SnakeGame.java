package game;

import entity.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JPanel implements ActionListener {

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGTH = 20;
    public static final int SPEED = 5;

    public Snake snake = new Snake(10, 10, 9, 10);
    Timer timer = new Timer(1000 / SPEED, this);

    public SnakeGame() {
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    @Override
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

        for (int d = 0; d < snake.length; d++) {

            graph.setColor(color(200, 200, 10));
            graph.fillRect(snake.snakeX[d] * SCALE + 1, snake.snakeY[d] * SCALE + 1, SCALE - 1, SCALE - 1);
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
        frame.setSize(WIDTH * SCALE + 1, HEIGTH * SCALE + 1);

        // Add JPanel (SnakeGame) to JFrame
        frame.add(new SnakeGame());

        // Sets the location of the window relative to the specified c
        // component according to the following scenarios.
        frame.setLocationRelativeTo(null);

        //Shows or hides this {@code Window} depending on the value of parameter
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        snake.move();

        repaint();
    }

    //Add KeyAdapter
    private class KeyBoard extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {

            int key = keyEvent.getKeyCode();

            if ((key == KeyEvent.VK_RIGHT) & snake.direction != 2) {
                snake.direction = 0;
            }
            if ((key == KeyEvent.VK_DOWN) & snake.direction != 3) {
                snake.direction = 1;
            }
            if ((key == KeyEvent.VK_LEFT) & snake.direction != 0) {
                snake.direction = 2;
            }
            if ((key == KeyEvent.VK_UP) & snake.direction != 1) {
                snake.direction = 3;
            }
        }

    }
}
