package edu.io;

import edu.io.token.PlayerToken;

public class Game {
    private Board board;
    private Player player;

    public void join(Player player) {
        this.player = player;
        this.board = new Board();
        this.player.assignToken(new PlayerToken(this.board));
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            this.board.display();
        }
    }
}
