package assignment2;

/**
 * This class stores the information of the grand floor gird.
 * 
 * @author Nick He
 */
public class GrandeFloorGrid extends FloorGrid{
	
	/**
	 *This construction contains objects of grand floor grid
	 *and includes a new seat array and initialize a 
	 *new floor grid.
	 */
	public GrandeFloorGrid()
	{
		this.row = 12;
		this.column = 9;
		this.rowOfFirstClass = 6;
		this.seats = new Seat[row][column];
		this.initialiseFloorGrid();
	}
 
	
	@Override
	public void initialiseFloorGrid() {
		
		for(int row = 0; row < this.row; row++)
		{
			for(int col = 0; col < this.column; col++)
			{
				Seat aSeat = new Seat();
				aSeat.seatPosition.row=row+1;
				aSeat.seatPosition.column=(char)(col+65);
				seats[row][col] = aSeat;
				if(row >= 0 && row < this.rowOfFirstClass)
				{
					seats[row][col].isFirstClass = true;
				}
				else
				{
					seats[row][col].isFirstClass = false;
				}
				
				if(col == 0 || col == 8)
				{
					seats[row][col].seatType = SeatType.WINDOW;
				}
				else if (col == 1 || col ==4 || col == 7)
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
