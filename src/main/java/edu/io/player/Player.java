package edu.io.player;

import edu.io.token.*;

public class Player {
    public final Gold gold = new Gold();
    private PlayerToken playerToken;
    private Token pickaxeToken = new EmptyToken();
    private Shed shed;

    public Player() {
        this.shed = new Shed();
    }

    public void assignToken(PlayerToken token) {
        this.playerToken = token;
    }

    public PlayerToken token() {
        return this.playerToken;
    }

    public double gold() {
        return this.gold.amount();
    }

    public void gainGold(double gold) {
        if (gold < 0) {
            throw new IllegalArgumentException("Gold cannot be negative");
        }
        this.gold.gain(gold);
    }

    public void loseGold(double gold) {
        if (gold > this.gold.amount()) {
            throw new IllegalArgumentException("Player cannot have negative gold");
        } else if (gold < 0) {
            throw new IllegalArgumentException("Gold cannot be negative");
        }
        this.gold.lose(gold);
    }

    public void interactWithToken(Token token) {
        if (token instanceof GoldToken goldToken) {
            if (this.pickaxeToken instanceof PickaxeToken pt) {
                this.shed.add(pt);
                if (pt.isBroken()){
                    this.pickaxeToken = new EmptyToken();
                    this.gainGold(goldToken.amount());
                } else {
                    this.gainGold(goldToken.amount() * pt.gainFactor());
                    pt.use();
                }
            } else {
                this.gold.gain(goldToken.amount());
            }
        } else if (token instanceof PickaxeToken pt) {
            this.pickaxeToken = pt;
        } else if (token instanceof AnvilToken anvilToken) {
            if (pickaxeToken instanceof PickaxeToken pt) {
                pt.repair();
            }
        }
    }
}
