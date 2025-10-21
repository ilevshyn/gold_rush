package edu.io.token;

import edu.io.Board;

public class PlayerToken extends Token {

    public PlayerToken() {
        super(Label.PLAYER_TOKEN_LABEL);
    }

    public PlayerToken(Board board) {
        super(Label.PLAYER_TOKEN_LABEL);
        this.board = board;
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
                this.board.placeToken(tempRow, tempCol, new EmptyToken());
                break;
            case RIGHT:
                if (this.pos.col() == this.board.size() - 1) {
                    throw new IllegalArgumentException("Cannot move outside of the board.");
                }
                this.pos = new Board.Coords(this.pos.row(), this.pos.col() + 1);
                this.board.placeToken(tempRow, tempCol, new EmptyToken());
                break;
            case UP:
                if (this.pos.row() == 0) {
                    throw new IllegalArgumentException("Cannot move outside of the board.");
                }
                this.pos = new Board.Coords(this.pos.row() - 1, this.pos.col());
                this.board.placeToken(this.pos.row(), this.pos.col(), this);
                this.board.placeToken(tempRow, tempCol, new EmptyToken());
                break;
            case DOWN:
                if (this.pos.row() == this.board.size() - 1) {
                    throw new IllegalArgumentException("Cannot move outside of the board.");
                }
                this.pos = new Board.Coords(this.pos.row() + 1, this.pos.col());
                this.board.placeToken(this.pos.row(), this.pos.col(), this);
                this.board.placeToken(tempRow, tempCol, new EmptyToken());
                break;
            default:
                break;
        }
    }

    public enum Move {
        NONE,
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
