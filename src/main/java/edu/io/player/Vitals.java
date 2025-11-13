package edu.io.player;

import org.jetbrains.annotations.NotNull;

public class Vitals {
    private int hydration;
    private Runnable onDeathCallback;

    public Vitals(){
        hydration = 100;
        onDeathCallback = () -> {};
    }

    public void setOnDeathHandler(@NotNull Runnable callback){
        if(callback == null){
            throw new NullPointerException("onDeathCallback can't be null");
        }
        this.onDeathCallback = callback;
    }

    public int hydration() {
        return hydration;
    }

    public void hydrate(int amount) {
        if (amount < 0){
            throw new IllegalArgumentException("amount can't be negative");
        }
        if ((hydration + amount) >= 100) {
            hydration = 100;
        } else  {
            hydration += amount;
        }
    }

    public void dehydrate(int amount) {

        if (amount < 0){
            throw new IllegalArgumentException("amount can't be negative");
        }
        if((hydration - amount) <= 0) {
            hydration = 0;
        } else {
            hydration -= amount;
        }
        if (!this.isAlive()){
            this.onDeathCallback.run();
        }
    }

    public boolean isAlive() {
        return hydration > 0;
    }
}
