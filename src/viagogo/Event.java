package viagogo;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Event {
	private int eventID;
	private double price;
	private Point location = new Point();
	
	public Event(int id, Point loc){
			eventID = id;
			location = loc;
			price = ThreadLocalRandom.current().nextDouble(10, 100);
		}
	
	public int getDistance(Point userLoc){
		int dist = (int) Point2D.distance(userLoc.getX(), userLoc.getY(), 
				location.getX(), location.getY());
		return dist;
	}
}
