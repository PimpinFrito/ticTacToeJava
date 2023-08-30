/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author fritzdev
 */
class Player {

    private String currentPlayer = "X";

    /**
     * Changes current player from X -> Y or vice versa
     */
    public void changeTurn() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }
     /**
      * Get String current player
      * @return Returns current player, 'X' or 'Y' 
      */
    public String getPlayer(){ return currentPlayer;}
}
