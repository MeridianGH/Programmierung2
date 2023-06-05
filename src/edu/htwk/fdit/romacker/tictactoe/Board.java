package edu.htwk.fdit.romacker.tictactoe;

import java.util.Scanner;

public class Board {
    private final int size;

    private final char[][] field;

    public Board(int size) {
        this.size = size;
        this.field = new char[size][size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.field[i][j] = ' ';
            }
        }
    }

    public void turn(Player player) {
        // Get address.
        System.out.print(player.getName() + "'s turn (" + player.getSymbol() + "): ");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();


        // Validate address.
        int i = (int)address.charAt(0) - (int)'A';
        int j = (int)address.charAt(1) - (int)'1';
        if (i < 0 || i > this.size - 1 || j < 0 || j > this.size - 1 || this.field[i][j] != ' ') {
            System.out.println("Invalid address.");
            this.turn(player);
            return;
        }

        // Set field.
        this.field[i][j] = player.getSymbol();
    }

    public void draw() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (j == 0) {
                    System.out.print(i == 0 ? "┌" : "├");
                } else {
                    System.out.print(i == 0 ? "┬" : "┼");
                }
                System.out.print("───");
                if (j == this.size - 1) {
                    System.out.print(i == 0 ? "┐" : "┤");
                }
            }
            System.out.println();

            for (int j = 0; j < this.size + 1; j++) {
                System.out.print("│ " + (j != this.size ? this.field[i][j] : (char)(i + (int)'A')) + " ");
                System.out.print(j != this.size ? "" : "\n");
            }
        }
        System.out.print("└───");
        for (int j = 0; j < this.size - 1; j++) { System.out.print("┴───"); }
        System.out.println("┘");
        for (int i = 0; i < this.size; i++) { System.out.print("  " + (char)(i + (int)'1') + " "); }
        System.out.println();
    }

    public char getPosition(int x, int y) {
        return this.field[x][y];
    }

    public int getSize() {
        return this.size;
    }
}
