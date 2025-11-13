package edu.io.token;

import static edu.io.token.Label.WATER_TOKEN_LABEL;

public class WaterToken extends Token {
    private int amount;

    public WaterToken() {
        super(WATER_TOKEN_LABEL);
        this.amount = 10;
    }

    public WaterToken(int amount) {
        super(WATER_TOKEN_LABEL);
        if (amount > 0 && amount <= 100) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Amount must be between 1 and 100");
        }
    }

    public int amount() {
        return amount;
    }
}
