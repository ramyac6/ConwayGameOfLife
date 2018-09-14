package edu.skyline;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Panel extends JPanel {
    private Board b;

    // Panel constructor
    public Panel() {
        setBackground(Color.black);
    }

    // Brings board into this class
    public void setBoard(Board b) {
        this.b = b;
    }

    // Colors board based on logic in Board class
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < Board.x; x++) {
            for (int y = 0; y < Board.y; y++) {

                final int x1 = x * (Board.CELL_LENGTH);
                final int y1 = y * (Board.CELL_LENGTH);

                if (this.b.current.get(x).get(y)) {
                    g.setColor(Color.green);
                    g.fillRect(x1, y1, Board.CELL_LENGTH + 1, Board.CELL_LENGTH + 1);

                } else {
                    g.setColor(Color.gray);
                    g.drawRect(x1, y1, Board.CELL_LENGTH, Board.CELL_LENGTH);
                }
            }
        }
    }

}
