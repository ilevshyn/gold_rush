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
        super(Label.PLAYER_TOKEN_LABEL);
        this.board = board;
        this.player = player;
        this.board.placeToken(4, 4, this);
        this.pos = new Board.Coords(4, 4);
    }


    public void move(Move dir) {
        int tempCol = this.pos.col();
        int tempRow = this.pos.row();
        switch (dir) {
            case LEFT:
                if (this.pos.col() == 0) {
                    throw new IllegalArgumentException("Cannot move outside of the board.");
                }
                this.pos = new Board.Coords(this.pos.row(), this.pos.col() - 1);
                break;
            case RIGHT:
                if (this.pos.col() == this.board.size() - 1) {
                    throw new IllegalArgumentException("Cannot move outside of the board.");
                }
                this.pos = new Board.Coords(this.pos.row(), this.pos.col() + 1);
                break;
            case UP:
                if (this.pos.row() == 0) {
                    throw new IllegalArgumentException("Cannot move outside of the board.");
                }
                this.pos = new Board.Coords(this.pos.row() - 1, this.pos.col());
                break;
            case DOWN:
                if (this.pos.row() == this.board.size() - 1) {
                    throw new IllegalArgumentException("Cannot move outside of the board.");
                }
                this.pos = new Board.Coords(this.pos.row() + 1, this.pos.col());
                break;
            default:
                break;
        }
        this.board.placeToken(this.pos.col(), this.pos.row(), this);
        this.board.placeToken(tempCol, tempRow, new EmptyToken());
        player.interactWithToken(board.peekToken(this.pos.col(), this.pos.row()));
    }


    public enum Move {
        NONE,
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
