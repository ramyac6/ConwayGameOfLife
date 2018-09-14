package edu.skyline;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    public static void main(String[] args) {

        // Create and initialize new board
        Board b = new Board();
        b.initialize();

        // Create JFrame
        JFrame frame = new JFrame("Game of Life");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(Board.BOARD_LENGTH + 30, Board.BOARD_WIDTH + 75);

        // Create panel and add to JFrame
        Panel panel = new Panel();
        panel.setBoard(b);
        frame.add(panel);

        // Timer that continually changes the state of the board
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.calculateNextState();
                b.switchState();
                panel.repaint();
            }
        });

        timer.start();

    }

}