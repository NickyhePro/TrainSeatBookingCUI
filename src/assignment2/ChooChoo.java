package assignment2;

/**
 * This class stores information of the ChooChoo operator.
 * @author Nick He
 *
 */
public class ChooChoo extends TrainOperator {

	/**
	 * This constructor sets the name of the Train 
	 * operator.
	 */
	public ChooChoo()
	{
		this.nameOfTrainOperator = "ChooChoo";
	}
	
	@Override
	Seat bookFirstclass(TrainJourney trainJourney, SeatType aSeatType) 
	{
		Seat aSeat= new Seat();
		aSeat = null;
		
		for(int i = 0; i < trainJourney.floorGrid.rowOfFirstClass; i++)
		{
			for(int j = 0; j<trainJourney.floorGrid.column; j++)
			{
				if(trainJourney.floorGrid.seats[i][j].seatType == aSeatType &&
				trainJourney.floorGrid.seats[i][j].booked == false && aSeat == null)
				{
					aSeat = trainJourney.floorGrid.seats[i][j];
					aSeat.booked = true;
				}
			}
		}
		if(aSeat == null)
		{
			for(int i=trainJourney.floorGrid.rowOfFirstClass; i<trainJourney.floorGrid.row; i++)
			{
				int result = 0;
				for(int j = 0; j<trainJourney.floorGrid.column; j++)
				{
					if(trainJourney.floorGrid.seats[i][j].booked == false)
					{
						result += 0;
					}
					else
					{
						result += 1;
					}
				}
				if(result == 0 && aSeat == null)
				{
					for(int j = 0; j<trainJourney.floorGrid.column; j++)
					{
						aSeat = trainJourney.floorGrid.seats[i][j];
						aSeat.booked = true;
					}
				}	
			}
		}
		return aSeat;	
	}

	@Override
	Seat bookEconomy(TrainJourney trainJourney, SeatType aSeatType)
	{	
		Seat aSeat = new Seat();
		aSeat = null;
		for(int i=trainJourney.floorGrid.rowOfFirstClass; i<trainJourney.floorGrid.row; i++)
		{
			for(int j=0; j<trainJourney.floorGrid.column; j++)
			{
				if(trainJourney.floorGrid.seats[i][j].seatType == aSeatType && 
				trainJourney.floorGrid.seats[i][j].booked == false && aSeat == null)
				{
					aSeat = trainJourney.floorGrid.seats[i][j];
					aSeat.booked = true;
				}
			}
		}
		return aSeat;
	}

}
