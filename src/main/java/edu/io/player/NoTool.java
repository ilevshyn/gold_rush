package edu.io.player;

import edu.io.token.Token;

public class NoTool implements Tool {
    @Override
    public Tool useWith(Token token) {
        return this;
    }

    @Override
    public Tool ifWorking(Runnable runnable) {
        return this;
    }

    @Override
    public Tool ifBroken(Runnable runnable) {
        return this;
    }

    @Override
    public Tool ifIdle(Runnable runnable) {
        return this;
    }

    @Override
    public boolean isBroken() {
        return false;
    }
}
