package viagogo;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Event {
	private int eventID;
	private double[] price = new double[5];
	private Point location = new Point();
	
	/**
	 * Create a new event with a given ID and location. 
	 * Prices are generated automatically.
	 * @param id
	 * @param loc
	 */
	public Event(int id, Point loc){
			eventID = id;
			location = loc;
			for (int i = 0; i < price.length; i++){
				price[i] = ThreadLocalRandom.current().nextDouble(10, 100);
			}
			//get lowest price
			Arrays.sort(price);
	}
	
	/**
	 * Returns a formatted string containing the details of the event.
	 * @return
	 */
	public String getDetails(){
		return "Event " + eventID + " - $" + String.format("%.2f", price[0]) + ", Location " + (int)location.getX() + "," + (int)location.getY();
	}
	
	/**
	 * Returns the distance of this event from a given location.
	 * @param userLoc
	 * @return
	 */
	public int getDistance(Point uPos){
		//Point2D uses Manhattan distance to calculate the distance between two points
		int dist = (int) Point2D.distance(uPos.getX(), uPos.getY(), 
				location.getX(), location.getY());
		return dist;
	}
}
