package edu.io;

import edu.io.token.*;

import java.util.Random;

public class Board {

    private final Token[][] grid;
    private final int size;
    private PlacementStrategy placementStrategy;

    public Board() {
        this.size = 8;
        this.grid = new Token[size][size];
        this.placementStrategy = PlacementStrategy.FIRST_AVAILABLE;
        this.clean();
    }

    public void setPlacementStrategy(PlacementStrategy placementStrategy) {
        this.placementStrategy = placementStrategy;
    }

    public Token peekToken(int col, int row) {
        return grid[row][col];
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

    public Coords getAvailableSquare(PlacementStrategy placementStrategy) {
        switch (placementStrategy) {
            case FIRST_AVAILABLE:
                for (int i = 0; i < this.size; i++) {
                    for (int j = 0; j < this.size; j++) {
                        if (this.grid[i][j] instanceof EmptyToken) {
                            return new Coords(i, j);
                        }
                    }
                }
                throw new IllegalStateException("No square available");
            case RANDOM:
                Random rand = new Random();
                int rows = grid.length;
                int cols = grid[0].length;
                int maxAttempts = rows * cols;
                for (int i = 0; i < maxAttempts; i++) {
                    int r = rand.nextInt(rows);
                    int c = rand.nextInt(cols);
                    if (this.grid[r][c] instanceof EmptyToken) {
                        return new Coords(r, c);
                    }
                }
                throw new IllegalStateException("No square available");
            default:
                throw new IllegalStateException("Unexpected value: " + placementStrategy);
        }
    }

    public Coords getAvailableSquare() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.grid[i][j] instanceof EmptyToken) {
                    return new Coords(i, j);
                }
            }
        }
        throw new IllegalStateException("No square available");
    }

    public enum PlacementStrategy {
        FIRST_AVAILABLE,
        RANDOM,
    }

    public record Coords(int row, int col) {
    }
}
