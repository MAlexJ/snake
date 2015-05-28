package game;

import javax.swing.*;

public class SnakeGame extends JPanel {

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGTH = 20;


    public static void main(String[] args) {

        JFrame frame = new JFrame();

        // Sets the operation that will happen by default
        // when the user initiates a "close" on this frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets whether this frame is resizable by the user.
        frame.setResizable(false);

        // The method changes the geometry-related data.
        frame.setSize(WIDTH*SCALE, HEIGTH*SCALE);

        // Sets the location of the window relative to the specified c
        // component according to the following scenarios.
        frame.setLocationRelativeTo(null);

        //Shows or hides this {@code Window} depending on the value of parameter
        frame.setVisible(true);

    }

}
