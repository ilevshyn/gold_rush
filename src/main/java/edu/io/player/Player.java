package edu.io.player;

import edu.io.token.*;

public class Player {
    public final Gold gold = new Gold();
    private PlayerToken playerToken;
    private Token pickaxeToken = new EmptyToken();
    private final Shed shed;

    public Player() {
        this.shed = new Shed();
    }

    public void assignToken(PlayerToken token) {
        this.playerToken = token;
    }

    public PlayerToken token() {
        return this.playerToken;
    }

    public void gainGold(double gold) {
        if (gold < 0) {
            throw new IllegalArgumentException("Gold cannot be negative");
        }
        this.gold.gain(gold);
    }

    private void usePickaxeOnGold(GoldToken goldToken, PickaxeToken pickaxeToken) {
        if (pickaxeToken.isBroken()){
            this.pickaxeToken = new EmptyToken();
            this.gainGold(goldToken.amount());
        } else {
            this.gainGold(goldToken.amount() * pickaxeToken.gainFactor());
            pickaxeToken.use();
        }
    }

    public void interactWithToken(Token token) {
        switch (token){
            case GoldToken goldToken:
                if (pickaxeToken instanceof PickaxeToken pt) {
                    usePickaxeOnGold(goldToken, pt);
                } else {
                    try {
                        this.pickaxeToken = (Token) shed.getTool();
                        if (pickaxeToken instanceof PickaxeToken pt) {
                            usePickaxeOnGold(goldToken, pt);
                        }
                    } catch (ClassCastException e) {
                        this.gainGold(goldToken.amount());
                    }
                }
                break;
            case PickaxeToken pickaxeToken1:
                if (this.pickaxeToken instanceof PickaxeToken) {
                    shed.add(pickaxeToken1);
                } else {
                    this.pickaxeToken = pickaxeToken1;
                }
                break;
            case AnvilToken _:
                if (this.pickaxeToken instanceof PickaxeToken pt) {
                    pt.repair();
                }
                break;
            default:
                break;
        }
    }
}
