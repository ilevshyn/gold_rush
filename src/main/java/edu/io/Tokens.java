package edu.io;

public enum Tokens {
    GOLD("\uD83D\uDCB0"),
    PLAYER("웃"),
    EMPTY("・");

    private final String symbol;

    Tokens(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
