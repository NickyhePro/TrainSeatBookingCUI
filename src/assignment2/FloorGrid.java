package assignment2;

/**
 * This class stores information about a floor grid 
 * of a train.
 * 
 * @author Nick He
 */
public abstract class FloorGrid {
	
	/**
	 * To initialize a new floor grid.
	 */
	abstract public void initialiseFloorGrid();
	
	protected Seat[][] seats;        //Initialize an array of seat
	protected int row;               //The number of the row
	protected int column;            //The number of the column
	protected int rowOfFirstClass;   //The number of the row of the first class
	
	/**
	 * Return the number of the last row
	 * 
	 * @return
	 */
	public int getLastRow()
	{
		return this.row;
	}
	
	/**
	 * Return the number of the last column
	 * 
	 * @return
	 */
	public char getLastCol()
	{
		return (char)(this.column+64);
	}
	
	/**
	 * Return the specific seat
	 * 
	 * @param nRows
	 * @param nCols
	 * @return
	 */
	public Seat getSeat(int nRows, char nCols)
	{
		return seats[nRows][nCols];
	}

	/**
	 * Return the left seat of a seat
	 * 
	 * @param aSeat
	 * @return
	 */
	public Seat getLeft(Seat aSeat)
	{
		if((int)(aSeat.seatPosition.column-65)>0)
		{
			return seats[aSeat.seatPosition.row][aSeat.seatPosition.column-1];
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Search available seats in economy class and 
	 * return a specific value.
	 * 
	 * @param aSeatType
	 * @return
	 */
	public Seat queryAvailableEconomySeat(SeatType aSeatType)
	{
		Seat aSeat = new Seat();
		aSeat = null;
		for(int i = rowOfFirstClass; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				if(seats[i][j].seatType == aSeatType && seats[i][j].booked == false && aSeat == null)
				{
					aSeat = seats[i][j];
				}
			}
		}
		if(aSeat == null)
		{
			for(int i = rowOfFirstClass; i < row; i++)
			{
				for(int j = 0; j < column; j++)
				{
					if(seats[i][j].booked == false && aSeat == null)
					{
						aSeat = seats[i][j];
					}
				}
			}
			if(aSeat == null)
			{
				return null;
			}
		}
		return aSeat;
	}
	
	/**
	 * Search available seats in first class
	 * and return a specific value.
	 *  
	 * @param aSeatType
	 * @return
	 */
	public Seat queryAvailableFirstClassSeat(SeatType aSeatType)
	{
		Seat aSeat = new Seat();
		aSeat = null;
		for(int i = 0; i < rowOfFirstClass; i++)
		{
			for(int j = 0; j < column; j++)
			{
				if(seats[i][j].seatType == aSeatType && seats[i][j].booked == false && aSeat == null)
				{
					aSeat = seats[i][j];
				}
			}
		}
		return aSeat;
	}

	/**
	 * The representation of the floor grid.
	 */
	public String toString()
	{
		String result= "     ";
		char col = 'A';
		for(int i = 0 ; i < this.column; i++)
		{
			result += col+"      ";
			col++;
		}
		result += "\n";
		int row = 1;
		for (Seat[] rows: seats)
		{
			result += String.format("%3d ", row);
			row++;
			for(Seat cols: rows)
			{
				result += cols+" ";
			}
			result += "\n";
		}
		return result;
	}
	
}
