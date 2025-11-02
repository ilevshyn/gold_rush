package edu.io.player;

import edu.io.token.Token;

public class NoTool implements Tool {
    @Override
    public Tool useWith(Token token) {
        return null;
    }

    @Override
    public Tool ifWorking(Runnable runnable) {
        return null;
    }

    @Override
    public Tool ifBroken(Runnable runnable) {
        return null;
    }

    @Override
    public Tool ifIdle(Runnable runnable) {
        return null;
    }

    @Override
    public boolean isBroken() {
        return false;
    }
}
