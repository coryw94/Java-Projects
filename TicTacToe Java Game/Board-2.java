
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.*;


public class Board extends JPanel implements ActionListener {

	// Variable declaration and initialization area.
	// Also references the Grid and Player classes.

	Grid grid;
	int pickCount=0;
	boolean playerAturn=true;
	Player computer, player1, player2;
	int winTally1;
	int winTally2;
	int winTallyCPU;
	int loseTallyCPU;
	int loseTally1;
	int loseTally2;

	JLabel status = new JLabel("");
	JLabel cpuTally = new JLabel("Wins: ");
	JLabel cpuLose = new JLabel("Losses: ");
	JLabel tally1 = new JLabel("Wins: ");
	JLabel player1Lose = new JLabel("Losses: ");
	JLabel tally2 = new JLabel("Wins: ");
	JLabel player2Lose = new JLabel("Losses: ");
	JButton btnNewGame = new JButton("New Game");
	JButton btnPlayer1 = new JButton("Player 1 Save");
	JButton btnPlayer2 = new JButton("Player 2 Save");
	JButton btnComputer = new JButton("Computer");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel bar = new JPanel();
	JButton btn1=new JButton("1");
	JButton btn2=new JButton("2");
	JButton btn3=new JButton("3");
	JButton btn4=new JButton("4");
	JButton btn5=new JButton("5");
	JButton btn6=new JButton("6");
	JButton btn7=new JButton("7");
	JButton btn8=new JButton("8");
	JButton btn9=new JButton("9");

	// Displays the objects used in the board.
	public Board (Grid grid, Player computer, Player player1, Player player2) {

		setLayout(new BorderLayout());

		this.player1=player1;
		this.player2=player2;
		this.computer=computer;
		this.grid = grid;

		bar.add(btnPlayer1);
		bar.add(tally1);
		bar.add(player1Lose);
		bar.add(btnPlayer2);
		bar.add(tally2);
		bar.add(player2Lose);
		bar.add(btnComputer);
		bar.add(cpuTally);
		bar.add(cpuLose);
		btnComputer.addActionListener(this);
		btnPlayer1.addActionListener(this);
		btnPlayer2.addActionListener(this);
		panel2.setLayout(new GridLayout(3,2));
		panel2.add(btn1);
		panel2.add(btn2);
		panel2.add(btn3);
		panel2.add(btn4);
		panel2.add(btn5);
		panel2.add(btn6);
		panel2.add(btn7);
		panel2.add(btn8);
		panel2.add(btn9);
		panel1.add(status);
		panel1.add(btnNewGame);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btnNewGame.addActionListener(this);

		setPreferredSize(new Dimension(600,500));
		add(bar, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(panel1, BorderLayout.SOUTH);
		btnPlayer1.setBackground(Color.red);

	}


	/*
	This area of the program is where the logic for each
	player move is determined. The game starts with Player 1
	by default and Player 1's move will always be "O". Player 2
	is X. Their respective moves are stored by either clicking
	 "Player 1 Save" or "Player 2 Save". There is also an option
	 to play against the computer. In order to do so, Player 1
	 must make a move and save it, then the Computer button must be
	 pressed. After the computer button is pressed, the Computer
	 will make a move and the Player 2 button must be pressed in order
	 to set the game back to Player 1. This is continued until a winner
	 is determined.
	 */
	public void actionPerformed(ActionEvent e) {

		String btnCaption=e.getActionCommand();

		// The random class is used to generate
		// random moves for the computer.
		Random rGenerator = new Random();
		int min = 1;
		int max = 9;
		int r = rGenerator.nextInt((max - min) + 1) + min;

		pickCount +=1;


		// This part of the program contains the logic
		// for determining the computer's move. When the Computer
		// button is clicked, the score for Player 2 is hidden since
		// Player 2 is being replaced by the computer. However, the Player 2
		// button will need to be clicked after saving the computer's move
		// in order to get the game back to Player 1.
		if (btnCaption=="Computer")
		{
			tally2.setVisible(false);
			player2Lose.setVisible(false);
			btnComputer.removeActionListener(this);
			btnPlayer1.addActionListener(this);
			pickCount=0;
			btnPlayer1.setBackground(Color.red);
			btnComputer.setBackground(Color.white);

			String b1 = btn1.getText();
			String b2 = btn2.getText();
			String b3 = btn3.getText();
			String b4 = btn4.getText();
			String b5 = btn5.getText();
			String b6 = btn6.getText();
			String b7 = btn7.getText();
			String b8 = btn8.getText();
			String b9 = btn9.getText();

			// Where the computer's move is set
			// The computer will always win or cause a draw.

			// Combinations that "block" the player from beating the computer.
			if (b5=="O")
				btn1.doClick();
			if (b1=="O"||b2=="O"||b3=="O"||b4=="O"||b6=="O"|| b7=="O"||b8=="O"||b9=="O"){
				btn5.doClick();
				if(b1=="O" && b2=="O")
					btn3.doClick();
				if(b1=="O" && b3=="O")
					btn2.doClick();
				if(b1=="O" && b4=="O")
					btn7.doClick();
				if(b1=="O" && b5=="O")
					btn9.doClick();
				if(b1=="O" && b7=="O")
					btn4.doClick();
				if(b1=="O" && b9=="O")
					btn5.doClick();
				if(b2=="O" && b1=="O")
					btn3.doClick();
				if(b2=="O" && b3=="O")
					btn1.doClick();
				if(b2=="O" && b5=="O")
					btn8.doClick();
				if(b2=="O" && b8=="O")
					btn5.doClick();
				if(b3=="O" && b1=="O")
					btn2.doClick();
				if(b3=="O" && b2=="O")
					btn1.doClick();
				if(b3=="O" && b5=="O")
					btn7.doClick();
				if(b3=="O" && b6=="O")
					btn9.doClick();
				if(b3=="O" && b7=="O")
					btn5.doClick();
				if(b3=="O" && b9=="O")
					btn6.doClick();
				if(b4=="O" && b1=="O")
					btn7.doClick();
				if(b4=="O" && b5=="O")
					btn6.doClick();
				if(b4=="O" && b6=="O")
					btn5.doClick();
				if(b4=="O" && b7=="O")
					btn1.doClick();
				if(b5=="O" && b1=="O")
					btn9.doClick();
				if(b5=="O" && b2=="O")
					btn8.doClick();
				if(b5=="O" && b3=="O")
					btn7.doClick();
				if(b5=="O" && b4=="O")
					btn6.doClick();
				if(b5=="O" && b6=="O")
					btn4.doClick();
				if(b5=="O" && b7=="O")
					btn3.doClick();
				if(b5=="O" && b9=="O")
					btn1.doClick();
				if(b6=="O" && b3=="O")
					btn9.doClick();
				if(b6=="O" && b4=="O")
					btn5.doClick();
				if(b6=="O" && b5=="O")
					btn4.doClick();
				if(b6=="O" && b9=="O")
					btn3.doClick();
				if(b7=="O" && b1=="O")
					btn4.doClick();
				if(b7=="O" && b3=="O")
					btn5.doClick();
				if(b7=="O" && b4=="O")
					btn1.doClick();
				if(b7=="O" && b5=="O")
					btn3.doClick();
				if(b7=="O" && b8=="O")
					btn9.doClick();
				if(b7=="O" && b9=="O")
					btn8.doClick();
				if(b8=="O" && b2=="O")
					btn5.doClick();
				if(b8=="O" && b5=="O")
					btn2.doClick();
				if(b8=="O" && b7=="O")
					btn9.doClick();
				if(b8=="O" && b9=="O")
					btn7.doClick();
				if (b9=="O" && b1=="O")
					btn5.doClick();
				if (b9=="O" && b3=="O")
					btn6.doClick();
				if (b9=="O" && b5=="O")
					btn1.doClick();
				if (b9=="O" && b6=="O")
					btn3.doClick();
				if (b9=="O" && b7=="O")
					btn8.doClick();
				if (b9=="O" && b8=="O")
					btn7.doClick();
			}
			else{ // Executes if the computer doesn't catch a combination
				switch(r){
					case 1: if(b1=="1"){
					    	btn1.doClick();
							btnComputer.removeActionListener(this);
							pickCount=0;
							break;
							}
					case 2: if(b2=="2"){
							btn2.doClick();
							btnComputer.removeActionListener(this);
							pickCount=0;
							break;
							}
					case 3: if(b3=="3"){
							btn3.doClick();
							btnComputer.removeActionListener(this);
							pickCount=0;
							break;
							}
					case 4: if(b4=="4"){
							btn4.doClick();
							btnComputer.removeActionListener(this);
							pickCount=0;
							break;
							}
					case 5:	if(b5=="5"){
							btn5.doClick();
							btnComputer.removeActionListener(this);
							pickCount=0;
							break;
							}

					case 6: if(b6=="6"){
							btn6.doClick();
							btnComputer.removeActionListener(this);
							pickCount=0;
							break;
							}

					case 7: if(b7=="7"){
							btn7.doClick();
							btnComputer.removeActionListener(this);
							pickCount=0;
							break;
							}
					case 8: if(b8=="8"){
							btn8.doClick();
							btnComputer.removeActionListener(this);
							pickCount=0;
							break;
							}

					case 9:	if(b9=="9"){
							btn9.doClick();
							btnComputer.removeActionListener(this);
							pickCount=0;
							break;
							}
						}


				playerAturn=true;

			}

			// Checks to see if the computer wins.
			if(computer.checkWin()) {
				System.out.println("Computer winner");
				status.setText("Computer winner");
				winTallyCPU +=1;
				int score;
				score = winTallyCPU;
				cpuTally.setText("Wins: " + Integer.toString(score));
				loseTally1 +=1;
				int loss;
				loss = loseTally1;
				player1Lose.setText("Losses: " + Integer.toString(loss));
				// Stop the game
				grid.reset();
				panel2.remove(btn1);
				panel2.remove(btn2);
				panel2.remove(btn3);
				panel2.remove(btn4);
				panel2.remove(btn5);
				panel2.remove(btn6);
				panel2.remove(btn7);
				panel2.remove(btn8);
				panel2.remove(btn9);
			}

		}

		// The new game button resets the buttons and labels and creates a new grid.
		// It also resets the players.
		if(btnCaption=="New Game")
		{
			pickCount=0;
			String ID;
			playerAturn=true;
			this.player1=player1;
			this.player2=player2;
			this.computer=computer;
			this.grid = grid;

			if (playerAturn)
				ID="O";
			else
				ID="X";

			grid.reset();

			// Reset the buttons and labels
			status.setText("");
			tally2.setVisible(true);
			player2Lose.setVisible(true);
			panel2.add(btn1);
			panel2.add(btn2);
			panel2.add(btn3);
			panel2.add(btn4);
			panel2.add(btn5);
			panel2.add(btn6);
			panel2.add(btn7);
			panel2.add(btn8);
			panel2.add(btn9);
			btn1.setText("1");
			btn1.removeActionListener(this);
			btn1.addActionListener(this);
			btn2.setText("2");
			btn2.removeActionListener(this);
			btn2.addActionListener(this);
			btn3.setText("3");
			btn3.removeActionListener(this);
			btn3.addActionListener(this);
			btn4.setText("4");
			btn4.removeActionListener(this);
			btn4.addActionListener(this);
			btn5.setText("5");
			btn5.removeActionListener(this);
			btn5.addActionListener(this);
			btn6.setText("6");
			btn6.removeActionListener(this);
			btn6.addActionListener(this);
			btn7.setText("7");
			btn7.removeActionListener(this);
			btn7.addActionListener(this);
			btn8.setText("8");
			btn8.removeActionListener(this);
			btn8.addActionListener(this);
			btn9.setText("9");
			btn9.removeActionListener(this);
			btn9.addActionListener(this);
			btnPlayer1.setBackground(Color.red);
			btnPlayer1.removeActionListener(this);
			btnPlayer1.addActionListener(this);
			btnPlayer2.setEnabled(true);
			btnPlayer2.removeActionListener(this);
			btnPlayer2.addActionListener(this);
			btnPlayer2.setBackground(null);
			btnComputer.removeActionListener(this);
			btnComputer.addActionListener(this);
			btnComputer.setBackground(null);

			return;

		}

		// This section of the program stores the players' moves

		if(btnCaption=="Player 1 Save") {
			btnPlayer1.removeActionListener(this);
			btnComputer.addActionListener(this);
			btnComputer.setBackground(Color.red);
			btnPlayer2.addActionListener(this);
			playerAturn=false;
			pickCount=0;
			btnPlayer2.setBackground(Color.red);
			btnPlayer1.setBackground(Color.white);

			// Determines if player 1 wins and adds the win to player 1's score
			if(player1.checkWin()) {
				System.out.println("player 1 winner");
				status.setText("Player 1 winner");
				winTally1 +=1;
				int score;
				score = winTally1;
				tally1.setText("Wins: " + Integer.toString(score));
				loseTallyCPU +=1;
				cpuLose.setText("Losses: " + Integer.toString(loseTallyCPU));
				int loss;
				// If you aren't playing against the computer..
				if(player2Lose.isVisible()){
					loseTally2 +=1;
					loss = loseTally2;
					player2Lose.setText("Losses: " + Integer.toString(loss));
				}
				// Stop the game if Player 1 wins
				grid.reset();
				panel2.remove(btn1);
				panel2.remove(btn2);
				panel2.remove(btn3);
				panel2.remove(btn4);
				panel2.remove(btn5);
				panel2.remove(btn6);
				panel2.remove(btn7);
				panel2.remove(btn8);
				panel2.remove(btn9);
			}

		}

		if(btnCaption=="Player 2 Save") {
			//send buttons clicked to player 1
			btnPlayer2.removeActionListener(this);
			btnPlayer1.addActionListener(this);
			btnPlayer1.setBackground(Color.red);
			btnPlayer2.setBackground(Color.white);
			playerAturn=true;
			pickCount=0;

			// Determine if player 2 wins and tally the score
			if(player2.checkWin()) {
				System.out.println("player 2 winner");
				status.setText("Player 2 winner");
				winTally2 += 1;
				int score;
				score = winTally2;
				tally2.setText("Wins: " + Integer.toString(score));
				loseTally1 += 1;
				int loss;
				loss = loseTally1;
				player1Lose.setText("Losses: " + Integer.toString(loss));

				// Stop the game if Player 2 wins
				grid.reset();
				panel2.remove(btn1);
				panel2.remove(btn2);
				panel2.remove(btn3);
				panel2.remove(btn4);
				panel2.remove(btn5);
				panel2.remove(btn6);
				panel2.remove(btn7);
				panel2.remove(btn8);
				panel2.remove(btn9);
			}
		}

		if(pickCount>1) return; //can only pick a max of 3

		String ID;


		// Store the moves for Player 1, 2, and the computer
		if(playerAturn) {
			player1.setPick(Integer.parseInt(btnCaption));
			ID="O";
		}
		else {
			player2.setPick(Integer.parseInt(btnCaption));
			ID="X";
			computer.setPick(Integer.parseInt(btnCaption));
			ID="X";
		}

		// This part of the program sets the text of the buttons
		//  to either "O" or "X" after they are clicked.

		switch(Integer.parseInt(btnCaption)) {
			case 1: btn1.removeActionListener(this);
					btn1.setText(ID);
					break;
			case 2: btn2.removeActionListener(this);
					btn2.setText(ID);
					break;
			case 3: btn3.removeActionListener(this);
					btn3.setText(ID);
					break;
			case 4: btn4.removeActionListener(this);
					btn4.setText(ID);
					break;
			case 5: btn5.removeActionListener(this);
					btn5.setText(ID);
					break;
			case 6: btn6.removeActionListener(this);
					btn6.setText(ID);
					break;
			case 7: btn7.removeActionListener(this);
					btn7.setText(ID);
					break;
			case 8: btn8.removeActionListener(this);
					btn8.setText(ID);
					break;
			case 9: btn9.removeActionListener(this);
					btn9.setText(ID);
					break;
		}

	}

}