package edu.io;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.placeToken(1, 1, new Token(Tokens.GOLD.getSymbol()));
        board.placeToken(4, 2, new Token(Tokens.PLAYER.getSymbol()));
        board.display();
    }
}
