package edu.io;

import edu.io.token.*;

public class Board {

    private final Token[][] grid;
    private final int size;

    public Board() {
        this.size = 8;
        this.grid = new Token[size][size];
        this.clean();
    }

    public Token peekToken(int col, int row) {
        return grid[row][col];
    }

    public Token square(int row, int col) {
        return this.grid[row][col];
    }

    public void placeToken(int col, int row, Token token) {
        this.grid[row][col] = token;
    }

    public void display() {
        for (var row : this.grid) {
            for (Token token : row) {
                switch (token) {
                    case PlayerToken pt -> System.out.print(Label.PLAYER_TOKEN_LABEL);
                    case EmptyToken empty -> System.out.print(Label.EMPTY_TOKEN_LABEL);
                    case GoldToken gt -> System.out.print(Label.GOLD_TOKEN_LABEL);
                    default -> throw new IllegalStateException("Unexpected value: " + token);
                }
            }
            System.out.println();
        }
    }

    public void clean() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.grid[i][j] = new EmptyToken();
            }
        }
    }

    public int size() {
        return size;
    }

    public record Coords(int row, int col) {
    }
}
