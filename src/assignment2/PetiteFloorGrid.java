package assignment2;

public class PetiteFloorGrid extends FloorGrid {
	
	/**
	 *This construction contains objects of grand floor grid
	 *and includes a new seat array and initialize a 
	 *new floor grid.
	 */
	public PetiteFloorGrid()
	{
		this.row = 10;
		this.column = 7;
		this.rowOfFirstClass = 4;
		this.seats = new Seat[row][column];
		this.initialiseFloorGrid();
	}

	@Override
	public void initialiseFloorGrid() {

		for(int row=0; row < this.row; row++)
		{
			for(int col=0; col < this.column; col++)
			{
				Seat aSeat = new Seat();
				seats[row][col] = aSeat;
				seats[row][col].seatPosition.row = row+1;
				seats[row][col].seatPosition.column = (char)(col+65);
				if(row >= 0 && row < this.rowOfFirstClass)
				{
					seats[row][col].isFirstClass = true;
				}
				else
				{
					seats[row][col].isFirstClass = false;
				}
				
				if(col == 0 || col == 6)
				{
					seats[row][col].seatType = SeatType.WINDOW;
				}
				else if(col == 3)
				{
					seats[row][col].seatType = SeatType.MIDDLE;
				}
				else
				{
					seats[row][col].seatType = SeatType.AISLE;
				}
			}
		}	
	}
}
