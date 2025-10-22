package edu.io.token;

public class GoldToken extends Token {
    private final double gold;

    public GoldToken() {
        super(Label.GOLD_TOKEN_LABEL);
        this.gold = 1.0;
    }

    public GoldToken(double amount) {
        super(Label.GOLD_TOKEN_LABEL);
        if (amount < 0) {
            throw new IllegalArgumentException("Gold token amount cannot be negative");
        }
        this.gold = amount;
    }

    public double amount() {
        return this.gold;
    }
}
