package viagogo;

//import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args){
		Point uPos = new Point();
		List<Event> events = new ArrayList<Event>();
		List<Event> closestEvents = new ArrayList<Event>();
		ArrayList<Point> list = new ArrayList<Point>(genLoc());
		//Create a list of events
		for(int i = 0; i < list.size(); i++){
			Event instance = new Event(i, list.get(i));
			events.add(instance);
		}
		
		uPos = getUserPos();
		
		closestEvents = sortEvents(events, uPos).stream().limit(5).collect(Collectors.toList());
		
		showEvents(closestEvents, uPos);
	}
	/**
	 * Get the coordinates from the user
	 * @return
	 */
	private static Point getUserPos() {
		Point uPos = new Point();
		System.out.println("Please Input Coordinates: ");
		Scanner scanner = new Scanner(System.in);
		String coordinates = scanner.nextLine();
		scanner.close();
		
		int commaLoc = coordinates.indexOf(",");
		uPos.x = Integer.parseInt(coordinates.substring(0,commaLoc));
		uPos.y = Integer.parseInt(coordinates.substring(commaLoc + 1));
		
		return uPos;
	}
	
	/**
	 * Sort the list of events by their distance from the user position
	 * @param events
	 * @param uPos
	 * @return
	 */
	private static List<Event> sortEvents(List<Event> events, Point uPos) {
		 Collections.sort(events, (Event e1, Event e2) 
				-> Integer.compare(e1.getDistance(uPos), e2.getDistance(uPos)));
		 return events;
	}
	
	/**
	 * Print the details of the first closest events to the user position
	 * @param closestEvents
	 * @param uPos
	 */
	private static void showEvents(List<Event> closestEvents, Point uPos) {
		System.out.printf("Closest Events to (%d,%d):\n", (int)uPos.getX(), (int)uPos.getY());
		for(int i = 0; i < closestEvents.size(); i++) {
			System.out.println(closestEvents.get(i).getDetails() 
					+ ", Distance " + closestEvents.get(i).getDistance(uPos));
		}
	}
	
	/**
	 * Generate a list of unique random coordinates.
	 * @return
	 */
	private static List<Point> genLoc() {
		Set<Point> set = new HashSet<Point>();
		Random position = new Random();
		Point test;
		
		for(int i = 0; i < 20; i++){
		    test = new Point();
		    test.x=position.nextInt(21) - 10;
		    test.y=position.nextInt(21) - 10;
		    set.add(test);     
		}

		List<Point> list = new ArrayList<Point>(set);
		return(list);
	}
}
