package edu.io;

import edu.io.token.GoldToken;
import edu.io.token.PlayerToken;
import edu.io.token.Token;

public class Player {
    private double gold;
    private PlayerToken playerToken;

    public Player() {
    }

    public void assignToken(PlayerToken token) {
        this.playerToken = token;
    }

    public PlayerToken token() {
        return this.playerToken;
    }

    public double gold() {
        return this.gold;
    }

    public void gainGold(double gold) {
        if (gold < 0) {
            throw new IllegalArgumentException("Gold cannot be negative");
        }
        this.gold += gold;
    }

    public void loseGold(double gold) {
        if (gold > this.gold) {
            throw new IllegalArgumentException("Player cannot have negative gold");
        } else if (gold < 0) {
            throw new IllegalArgumentException("Gold cannot be negative");
        }
        this.gold -= gold;
    }

    public void interactWithToken(Token token) {
        if (token instanceof GoldToken goldToken) {
            this.gainGold(goldToken.amount());
        }
    }
}
