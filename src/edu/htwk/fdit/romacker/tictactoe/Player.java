package edu.htwk.fdit.romacker.tictactoe;

public class Player {
    public static char[] SYMBOLS = {'X', 'O'};
    private String name;

    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
