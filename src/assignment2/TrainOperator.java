package assignment2;

/**
 * This class stores information of a train operation.
 * 
 * @author Nick He
 */
public abstract class TrainOperator {
	
	protected String nameOfTrainOperator;          //The name of the train operator
	
	/**
	 * Set a name of the train operator.
	 * 
	 * @param nameOfTrainOperator
	 */
	public void SetNameOfTrainOperator(String nameOfTrainOperator)
	{
		this.nameOfTrainOperator = nameOfTrainOperator;
	}
	
	/**
	 * return the name of the train operator.
	 * 
	 * @return
	 */
	public String getNameTrainOperator()
	{
		return this.nameOfTrainOperator;
	}
	
	/**
	 * The representation of a train operator.
	 */
	public String toString()
	{
		String result = "";
		result += "Welcome to the "+this.nameOfTrainOperator+" booking system\n";
		result += "Which train journey would you like to book a seat on?";
		return result;
	}
	
    /**
     * The method to book a specific seat in first class
     * and return this seat.
     * 
     * @param trainJourney
     * @param aSeatType
     * @return
     */
	abstract Seat bookFirstclass(TrainJourney trainJourney, SeatType aSeatType);

	/**
     * The method to book a specific seat in economy class
     * and return this seat.
     * 
     * @param trainJourney
     * @param aSeatType
     * @return
     */
	abstract Seat bookEconomy(TrainJourney trainJourney, SeatType aSeatType);
	


}
