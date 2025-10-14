package edu.io;

public class Token {

    public String label;

    public Token(String symbol) {
        this.label = symbol;
    }

    @Override
    public String toString() {
        return label;
    }
}
