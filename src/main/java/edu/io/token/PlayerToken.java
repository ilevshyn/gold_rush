package edu.io.token;

import edu.io.Board;
import edu.io.player.Player;

public class PlayerToken extends Token {

    private Player player;


    public PlayerToken(Board board) {
        super(Label.PLAYER_TOKEN_LABEL);
        this.board = board;
        this.board.placeToken(4, 4, this);
        this.pos = new Board.Coords(4, 4);
    }

    public PlayerToken(Player player, Board board) {
        if (player == null || board == null) {
            throw new NullPointerException("player or board is null");
        }
        super(Label.PLAYER_TOKEN_LABEL);
        this.board = board;
        this.player = player;
        this.board.placeToken(4, 4, this);
        this.pos = new Board.Coords(4, 4);
    }

    private void ensureInBounds (int row, int col){
        int n = this.board.size();
        if (row < 0 || col < 0 || row >= n || col >= n) {
            throw new IllegalArgumentException("Cannot move outside of the board");
        }
    }

    public void move(Move dir) {
        final int tempCol = this.pos.col();
        final int tempRow = this.pos.row();

        int calcRow = 0;
        int calcCol = 0;

        switch (dir) {
            case UP:
                calcRow = -1;
                break;
            case DOWN:
                calcRow = 1;
                break;
            case LEFT:
                calcCol = -1;
                break;
            case RIGHT:
                calcCol = 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid move direction");
        }

        final int finalRow = tempRow + calcRow;
        final int finalCol = tempCol + calcCol;

        ensureInBounds(finalRow, finalCol);

        var targetToken = board.peekToken(finalCol, finalRow);
        player.interactWithToken(targetToken);

        board.placeToken(finalCol, finalRow, this);
        board.placeToken(tempCol, tempRow, new EmptyToken());
        this.pos = new Board.Coords(finalRow, finalCol);
    }


    public enum Move {
        NONE,
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
