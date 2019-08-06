

public class Grid {


	 String cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9;

	public Grid() {
		cell1=cell2=cell3=cell4=cell5=cell6=cell7=cell8=cell9="";


	}

	// Updates each players' moves.

	public void updateGrid(String ID, int cellA) {

		switch (cellA) {
			case 1: cell1=ID;break;
			case 2: cell2=ID;break;
			case 3: cell3=ID;break;
			case 4: cell4=ID;break;
			case 5: cell5=ID;break;
			case 6: cell6=ID;break;
			case 7: cell7=ID;break;
			case 8: cell8=ID;break;
			case 9: cell9=ID;break;

		}


	}


	// Determines the winner by scanning the board for either 3 consecutive "X"s or "O"s.
	public boolean winner(String ID) {

		if (cell1==ID && cell2==ID && cell3==ID)
			return true;
		if (cell4==ID && cell5==ID && cell6==ID)
			return true;
		if (cell7==ID && cell8==ID && cell9==ID)
			return true;
		if (cell1==ID && cell4==ID && cell7==ID)
			return true;
		if (cell2==ID && cell5==ID && cell8==ID)
			return true;
		if (cell3==ID && cell6==ID && cell9==ID)
			return true;
		if (cell1==ID && cell5==ID && cell9==ID)
			return true;
		if (cell3==ID && cell5==ID && cell7==ID)
			return true;
		else
			return false;
	}

	// Resets the grid
	public void reset()
	{
		cell1="";
		cell2="";
		cell3="";
		cell4="";
		cell5="";
		cell6="";
		cell7="";
		cell8="";
		cell9="";
	}

}