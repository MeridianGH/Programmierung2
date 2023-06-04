package edu.htwk.fdit.romacker.tictactoe;

enum gameState {
    RUNNING,
    WIN,
    LOSS
}

public class TicTacToe {
    private gameState state = gameState.RUNNING;

    private final Player[] players;

    private final Board board;

    public TicTacToe(int boardSize, int playerCount) {
        this.board = new Board(boardSize);
        this.players = new Player[playerCount];
        for (int i = 0; i < playerCount; i++) {
            this.players[i] = new Player("Player " + (i + 1), i < Player.SYMBOLS.length ? Player.SYMBOLS[i] : (char)(i + (int)'1'));
        }
    }

    public TicTacToe(Board board, Player... players) {
        this.board = board;
        this.players = players;
    }

    public void start() {
        this.board.draw();
        while (true) {
            int i;
            for (i = 0; i < this.players.length; i++) {
                Player player = this.players[i];
                this.board.turn(player);
                this.board.draw();
                this.state = this.checkGameState(player);
                if (this.state != gameState.RUNNING) { break; }
            }

            if (this.state == gameState.LOSS) {
                System.out.println("Board is full. No one wins!");
                break;
            }
            if (this.state == gameState.WIN) {
                System.out.println(players[i].getName() + " (" + players[i].getSymbol() + ") wins!");
                break;
            }
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private gameState checkGameState(Player player) {
        // Row or Column win.
        for (int i = 0; i < board.getSize(); i++) {
            // Rows.
            char r = board.getPosition(i, 0);
            for (int j = 0; j < board.getSize(); j++) {
                if (r == 0 || board.getPosition(i, j) != r) { break; }
                if (j == board.getSize() - 1) {
                    if (r == player.getSymbol()) { return gameState.WIN; }
                }
            }
            // Columns.
            char c = board.getPosition(0, i);
            for (int j = 0; j < board.getSize(); j++) {
                if (c == 0 || board.getPosition(j, i) != c) { break; }
                if (j == board.getSize() - 1) {
                    if (c == player.getSymbol()) { return gameState.WIN; }
                }
            }
        }

        // Downwards diagonal win.
        char downC = board.getPosition(0, 0);

        for (int i = 0; i < board.getSize(); i++) {
            if (downC == 0 || board.getPosition(i, i) != downC) { break; }
            if (i == board.getSize() - 1 && downC == player.getSymbol()) { return gameState.WIN; }
        }
        // Upwards diagonal win
        char upC = board.getPosition(board.getSize() - 1, 0);
        for (int i = 0; i < board.getSize(); i++) {
            if (upC == 0 || board.getPosition(board.getSize() - 1 - i, i) != upC) { break; }
            if (i == board.getSize() - 1 && upC == player.getSymbol()) { return gameState.WIN; }
        }

        // Still empty fields, keep running.
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getPosition(i, j) == ' ') {
                    return gameState.RUNNING;
                }
            }
        }

        // No win and no empty fields.
        return gameState.LOSS;
    }
}
