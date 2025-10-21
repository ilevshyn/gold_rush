package edu.io.token;

import edu.io.Board;

public abstract class Token {
    private final String label;
    protected Board.Coords pos;
    protected Board board;

    public Token(String label) {
        this.label = label;
    }


    public String label() {
        return label;
    }

    public Board.Coords pos() {
        return pos;
    }
}
