package edu.io;

public class Board {

    public int size;

    private final Token[][] grid;

    public Token square(int row, int col){
        return this.grid[row][col];
    };

    public void placeToken(int row, int col, Token token){
        this.grid[row][col] = token;
    }

    public void display(){
        for(var row : this.grid){
            for(var cell : row){
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public void clean(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                this.grid[i][j] = new Token(Tokens.EMPTY.getSymbol());
            }
        }
    }

    public Board() {
        this.size = 8;
        this.grid = new Token[size][size];
        this.clean();
    }
}
