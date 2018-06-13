package assignment2;

import java.util.*;

/**
 * This class stores the information of a train
 * seat booking application.
 * 
 * @author Nick He
 */
public class TrainSeatBookingApplication {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
	
		System.out.println("Which train operator would you like to travel with?");
		TrainOperator operator = null;             //Initialize a new train operator
		System.out.println("1: TrainWay");
		System.out.println("2: ChooChoo");
		
		int choiceOfOperator = keyboard.nextInt();
		if(choiceOfOperator == 1)
		{
			operator = new TrainWay();
		}
		else if(choiceOfOperator == 2)
		{
			operator = new ChooChoo();
		}
		System.out.println(operator);

		TrainJourney[] trainJourney = new TrainJourney[2];        //Initialize an array of train journeys
		trainJourney[0] = new TrainJourney("London", "York", "17:00h", "TJ1000", "Grande");
		trainJourney[1] = new TrainJourney("Swansea", "Sheffield", "08:00h", "TJ2000", "Petite");
		System.out.println("1: "+trainJourney[0]);
		System.out.println("2: "+trainJourney[1]);	
		
		int choiceOfJourney = 0;
		choiceOfJourney	= keyboard.nextInt();
		System.out.println("Booking seats for "+trainJourney[choiceOfJourney-1]);
		System.out.println(trainJourney[choiceOfJourney-1].floorGrid);
	
		int choiceOfClass = 0;
		int choiceOfSeatType = 0;
		do
		{
			System.out.println("1. Book in First Class");
			System.out.println("2. Book in Economy Class");
			System.out.println("3. Show Floor Grid");
			System.out.println("4. Quit");
			choiceOfClass = keyboard.nextInt();
		
		if(choiceOfClass >= 1 && choiceOfClass <= 2)
		{
			System.out.println("Which seat type?");
			System.out.println("1. WINDOW");
			System.out.println("2. AISLE");
			System.out.println("3. MIDDLE");
			choiceOfSeatType = keyboard.nextInt();
			
			SeatType seatType = null;
			if(choiceOfSeatType == 1)
			{
				seatType = SeatType.WINDOW;
			}
			else if(choiceOfSeatType == 2)
			{
				seatType = SeatType.AISLE;
			}
			else if(choiceOfSeatType == 3)
			{
				seatType = SeatType.MIDDLE;
			}
			
			Seat aSeat;
			if(choiceOfClass == 1)
			{
				aSeat = operator.bookFirstclass(trainJourney[choiceOfJourney-1], seatType);
			}
			else
			{
				aSeat = operator.bookEconomy(trainJourney[choiceOfJourney-1], seatType);
			}
			
			if(aSeat == null)
			{
				System.out.println(trainJourney[choiceOfJourney-1].floorGrid);
				System.out.println("Sorry, we could not book the requested seat");
			}
			else
			{
				System.out.println(trainJourney[choiceOfJourney-1].floorGrid);
				if(choiceOfClass == 1)
				{
					System.out.println("Seat reservation: First class "+aSeat.seatType+" seat at: "+aSeat.seatPosition.row+Character.toString(aSeat.seatPosition.column)+" is reserved\n");
				}
				else
				{
					System.out.println("Seat reservation: Economy class "+aSeat.seatType+" seat at: "+aSeat.seatPosition.row+Character.toString(aSeat.seatPosition.column)+" is reserved\n");
				}	
			}
		}
		else if(choiceOfClass == 3)
		{
			System.out.println(trainJourney[choiceOfJourney-1].floorGrid);
		}
		else if(choiceOfClass == 4)
		{
			System.out.println("Goodbye.");
		}
		else
		{
			System.out.println("Sorry, we could not book the requested seat");
		}
		}while(choiceOfClass != 4);
		
		keyboard.close();
	}

}
