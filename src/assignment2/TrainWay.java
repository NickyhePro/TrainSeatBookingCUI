package assignment2;

/**
 * This class stores information of the TrainWay operator.
 * 
 * @author Nick He
 */
public class TrainWay extends TrainOperator{

	/**
	 * This constructor sets the name of the Train 
	 * operator.
	 */
	public TrainWay()
	{
		this.SetNameOfTrainOperator("TrainWay");
	}
	
	@Override
	Seat bookFirstclass(TrainJourney trainJourney, SeatType aSeatType) 
	{
		Seat aSeat = new Seat();
		aSeat = null;
		
		for(int i = 0; i < trainJourney.floorGrid.rowOfFirstClass; i++)
		{
			for(int j = 0; j < trainJourney.floorGrid.column; j++)
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
			for(int i = 0; i < trainJourney.floorGrid.rowOfFirstClass; i++)
			{
				for(int j = 0; j < trainJourney.floorGrid.column; j++)
				{
					if(trainJourney.floorGrid.seats[i][j].booked == false && aSeat == null)
					{
						aSeat = trainJourney.floorGrid.seats[i][j];
						aSeat.booked = true;
					}
				}
			}
			
			if(aSeat == null)
			{
				for(int i = trainJourney.floorGrid.rowOfFirstClass; i < trainJourney.floorGrid.row; i++)
				{
					for(int j = 0; j < trainJourney.floorGrid.column; j++)
					{
						if(trainJourney.floorGrid.seats[i][j].seatType == SeatType.WINDOW &&
						trainJourney.floorGrid.seats[i][j].booked == false && aSeat == null)
						{
							aSeat = trainJourney.floorGrid.seats[i][j];
							aSeat.booked = true; 
						}
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
		for(int i = trainJourney.floorGrid.rowOfFirstClass; i < trainJourney.floorGrid.row; i++)
		{
			for(int j = 0; j < trainJourney.floorGrid.column; j++)
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
			for(int i = 0; i < trainJourney.floorGrid.rowOfFirstClass; i++)
			{
				for(int j = 0; j < trainJourney.floorGrid.column; j++)
				{
					if(trainJourney.floorGrid.seats[i][j].seatType == SeatType.WINDOW &&
					trainJourney.floorGrid.seats[i][j].booked == false && aSeat == null)
					{
						aSeat = trainJourney.floorGrid.seats[i][j];
						aSeat.booked = true;
						
					}
				}
			}
		}	
		return aSeat;
	}
	
}