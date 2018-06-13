package assignment2;

/**
 * This class stores information about the seat of trains.
 * IT includes some data including booking state, the class of seat and seat type.
 *
 * @author Nick He
 */
public class Seat {

	boolean booked;          //The booking state of a seat
	boolean isFirstClass;    //The class of a seat
	SeatType seatType;       //The seat type of a seat
	
	SeatPosition seatPosition=new SeatPosition();
	
	/**
	 * The representation of this class.
	 */
	public String toString()
	{
		String result = "";
		if(this.booked == true && this.isFirstClass == true)
		{
			result += "["+this.seatType.toString().charAt(0)+" X ]";
		}
		else if(this.booked == false && this.isFirstClass == true)
		{
			result += "["+this.seatType.toString().charAt(0)+" _ ]";
		}
		else if(this.booked == false && this.isFirstClass == false)
		{
			result += "["+this.seatType.toString().toLowerCase().charAt(0)+" _ ]";
		}
		else
		{
			result += "["+this.seatType.toString().toLowerCase().charAt(0)+" X ]";
		}
		return result;
	}
	
}
