package edu.io.player;

public class Gold {
    private double amount;

    public Gold(double amount){
        if (amount < 0) throw new IllegalArgumentException("Gold cannot be negative");
        this.amount = amount;
    }

    public Gold(){
        this.amount = 0.0;
    }

    public double amount(){
        return this.amount;
    }

    public void gain(double amount){
        if (amount < 0) throw new IllegalArgumentException("Gold cannot be negative");
        this.amount += amount;
    }

    public void lose(double amount){
        if (this.amount - amount < 0) throw new IllegalArgumentException("Gold cannot be negative");
        else if (amount < 0) throw new IllegalArgumentException("Gold cannot be negative");
        this.amount -= amount;
    }
}
