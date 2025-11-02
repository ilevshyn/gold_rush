package edu.io.player;

import edu.io.token.Token;

public interface Tool {
    public Tool useWith(Token token);
    public Tool ifWorking(Runnable runnable);
    public Tool ifBroken(Runnable runnable);
    public Tool ifIdle(Runnable runnable);
    public boolean isBroken();
}
