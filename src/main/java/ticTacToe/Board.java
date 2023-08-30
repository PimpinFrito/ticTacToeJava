/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import java.util.Arrays;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author fritzdev
 */
public class Board {

    private GridPane boardView = new GridPane();
    private String[][] board = new String[3][3];
    private Player player = new Player();
    private boolean gameOver;
    private boolean boardFull = false;
    private Label status;

    //Check if current player won
    //Find way to have player show up on menu
    public Board(Player player, Label status) {
        createView();
        gameOver = false;
        this.status = status;
        updateStatus();
        
    }

    private void createView() {
        boardView.setPrefSize(400, 400);
        boardView.setAlignment(Pos.CENTER);
        addButtons();

    }

    public void addButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button btn = new Button();
                btn.setPrefSize(90, 90);
                btn.setFont(Font.font("Monospaced", 45));
                System.out.println("Row: " + row + "Col: " + col);
                final int finalRow = row;
                final int finalCol = col;

                btn.setOnAction(event -> {
                    if (btn.getText().isBlank() && !gameOver && !isBoardFull()) {                       
                        btn.setText(player.getPlayer());  
                        updateBoard(finalCol, finalRow);
                    }
                });
                boardView.add(btn, row, col);
            }
        }
    }

    public void updateBoard(int row, int col) {
        board[row][col] = player.getPlayer();
        checkIfPlayerWon();
        printBoard();
        if(!gameOver) player.changeTurn();
        updateStatus();
    }

    private void printBoard() {
        for (String[] boardRow : board) {
            System.out.println(Arrays.toString(boardRow));

        }
        System.out.println("- - - - - - - -");
    }

    public GridPane getView() {
        return boardView;
    }

    private void checkIfPlayerWon() {
        for (String[] row : board) {
            if (gameOver) return;
            
            //Check rows
            if (   checkSquare(row[0])
                && checkSquare(row[1])
                && checkSquare(row[2])) {
                System.out.println("Game over: Row");
                gameOver = true;
            }
        }
        //Check columns
        for(int col = 0; col < 3; col++){
            if (gameOver) return;
            
            if(     checkSquare(board[0][col]) &&
                    checkSquare(board[1][col]) &&
                    checkSquare(board[2][col]) ){
                System.out.println("Game over Col");
                gameOver = true;
            }
        }
        
        //Check diagonals
        for(int square = 0; square < 3; square++){
            if (gameOver) return;
            
            if(     checkSquare(board[0][0]) &&
                    checkSquare(board[1][1]) &&
                    checkSquare(board[2][2]) ){
                System.out.println("Game over diagonal");
                gameOver = true;
            }
        }
        
        //Check diagonals
        for(int col = 0; col < 3; col++){
            if (gameOver) return;
            
            if(     checkSquare(board[2][col]) &&
                    checkSquare(board[1][col]) &&
                    checkSquare(board[0][col]) ){
                System.out.println("Game over diagonal");
                gameOver = true;
            }
        }
    }

    public boolean checkSquare(String square) {
        if (square == null) {
            return false;
        }
        return square.equals(player.getPlayer());
    }
    
    public boolean isBoardFull(){
        //boolean freeSpace = false;
        for(String[] row: board){
            for(String square: row){
                if(square == null) return false;
            }
        }
        return true;
    }

    /**
     * Updates the menu label to the current player if the game is over, updates
     * the label to "game over" 
     */
    private void updateStatus() {
        if (gameOver) {
            status.setText("The end!");
            //status.setText("Game Over: " + player.getPlayer() + " wins");
        } else if(isBoardFull()) {
            status.setText("The end!");
        }        
           else {
            status.setText("Turn: " + player.getPlayer());
        }
    }
}
