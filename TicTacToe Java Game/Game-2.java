
import javax.swing.*;
import java.awt.*;

// This class starts the game, builds the board, and sets the players.


public class Game {



    public static void main(String [] args) {
		JFrame frame=new JFrame("TicTacToe");
        Grid grid = new Grid();
        Player computer = new Player("X",grid);
        Player player1 = new Player("O",grid);
        Player player2 = new Player("X",grid);
        Board gameBoard = new Board(grid, computer, player1, player2);
        frame.getContentPane().add(gameBoard);
        frame.pack();
        frame.setVisible(true);
		frame.setSize(800,500);
    }

}





