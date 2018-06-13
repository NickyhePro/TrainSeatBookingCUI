package assignment2;

/**
 * This class stores information about a train journey.
 * It includes some data such as the start of city, destination,
 * departing time, journey number and floor gird.
 *  
 * @author Nick He
 */
public class TrainJourney {
	
	String startCity;              //The name of the city of departure
	String destination;            //The name of the city of destination
	String departureTime;          //The time of departure
	String journeyNumber;          //The number of train journey
	FloorGrid floorGrid;           //The seat floor grid of a train
	
	/**
	 * Constructor for objects of the train journey.
	 * 
	 * @param startCity
	 * @param destination
	 * @param departureTime
	 * @param journeyNumber
	 * @param gridType
	 */
	public TrainJourney(String startCity, String destination, String departureTime, String journeyNumber, String gridType)
	{
		this.startCity = startCity;
		this.destination = destination;
		this.departureTime = departureTime;
		this.journeyNumber = journeyNumber;
		if(gridType == "Grande")
		{
			this.floorGrid = new GrandeFloorGrid();
		}
		else if(gridType == "Petite")
		{
			this.floorGrid = new PetiteFloorGrid();
		}
		
	}

	/**
	 * The representation of a train journey.
	 */
	public String toString()
	{
		return "Journey: "+this.journeyNumber+" from: "+this.startCity+" to: "+this.destination+" departing: "+this.departureTime;
	}
}
