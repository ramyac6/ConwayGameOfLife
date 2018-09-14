package edu.skyline;

import java.util.*;

public class Board {
    public static ArrayList<ArrayList<Boolean>> current = new ArrayList<ArrayList<Boolean>>();
    public static ArrayList<ArrayList<Boolean>> next = new ArrayList<ArrayList<Boolean>>();

    public static int BOARD_LENGTH = 1200;
    public static int BOARD_WIDTH = 600;

    public static final int CELL_LENGTH = 20;

    public static int x = BOARD_LENGTH / (CELL_LENGTH); //Number of columns
    public static int y = BOARD_WIDTH / (CELL_LENGTH); //Number of rows

    //Board Constructor
    public Board() { }

    //Creates new boards populated with false
    public void initialize() {
        for (int i = 0; i < x; i++) {
            current.add(new ArrayList<Boolean>());
            next.add(new ArrayList<Boolean>());
            for (int j = 0; j < y; j++) {
                current.get(i).add(false);
                next.get(i).add(false);
            }
        }
        randomize();
        //testBlinker();
    }

    // To test if panel is working
    public void testBlinker() {
        current.get(1).set(2, true);
        current.get(2).set(2, true);
        current.get(3).set(2, true);
    }

    // Randomizes cells
    public void randomize() {
        for (int n = 0; n < 1000; n++) {
            current.get((int) (Math.random() * x)).set((int) (Math.random() * y), true);
        }
    }


    // Calculates and sets next state
    public void calculateNextState() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                setState(i, j, calculateCellState(i, j));
            }
        }
    }

    // Calculates next cell state
    private Boolean calculateCellState(int m, int n) {
        int totalActive = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (m + i == -1 || n + j == -1 || m + i == x || n + j == y) {

                } else {
                    if (current.get(m + i).get(n + j)) totalActive++;
                }
            }
        }
        if (totalActive == 3) return true;
        if (totalActive == 4) return current.get(m).get(n);
        return false;
    }

    // sets new state in next ArrayList
    private void setState(int m, int n, boolean state) {
        next.get(m).set(n, state);
    }

    // sets current to next, and discards next
    public void switchState() {
        ArrayList<ArrayList<Boolean>> temp = current;
        current = next;
        next = temp;
        resetNextBoard();
    }

    // resets the next board
    private void resetNextBoard() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                next.get(i).set(j, false);
            }
        }
    }

}