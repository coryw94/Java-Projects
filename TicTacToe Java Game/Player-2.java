
// Class that creates the players and sets the IDs for them (either X or O).

public class Player {


	Grid grid;
	String MyID;

	public Player(String ID, Grid grid) {
		this.grid = grid;
		MyID=ID;

	}

	public void setPick(int cell) {

		grid.updateGrid(MyID, cell);
	}

	public boolean checkWin() {
		//check to see if there is one button left
		if(grid.winner(MyID)) return true;
		else return false;

	}


}