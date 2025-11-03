package edu.io.token;

import edu.io.Repairable;
import edu.io.player.Player;
import edu.io.player.Tool;

public class PickaxeToken extends Token implements Tool, Repairable {
    private double gainFactor;
    private int durability;
    private int initialDurability;

    public PickaxeToken(double gainFactor) {
        this();
        if (gainFactor <= 0) {
            throw new IllegalArgumentException("gainFactor must be greater than 0.");
        }
        this.gainFactor = gainFactor;
    }

    public PickaxeToken(double gainFactor, int durability) {
        this(gainFactor);
        if (durability <= 0) {
            throw new IllegalArgumentException("durability must be greater than 0.");
        }
        this.durability = durability;
        this.initialDurability = durability;
    }

    public PickaxeToken() {
        super("⛏");
        this.gainFactor = 1.5;
        this.initialDurability = 3;
        this.durability = this.initialDurability;
    }

    public double gainFactor() {
        return gainFactor;
    }

    public int durability() {
        return durability;
    }

    public void use(){
        this.durability--;
    }

    @Override
    public Tool useWith(Token token) {
        switch (token) {
            case GoldToken gd:
                this.use();
                break;
            case EmptyToken et:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + token);
        }
        return this;
    }

    @Override
    public Tool ifWorking(Runnable runnable) {
        return this;
    }

    @Override
    public Tool ifBroken(Runnable runnable) {
        if (this.isBroken()) {
            runnable.run();
        }
        return this;
    }

    @Override
    public Tool ifIdle(Runnable runnable) {
        return this;
    }

    public boolean isBroken(){
        return this.durability <= 0;
    }

    public void repair(){
        this.durability = this.initialDurability;
    }
}
