package edu.io;

import edu.io.token.EmptyToken;
import edu.io.token.Token;

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

    public void placeToken(int row, int col, Token token) {
        this.grid[row][col] = token;
    }

    public void display() {
        for (var row : this.grid) {
            for (var cell : row) {
                System.out.print(cell);
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
