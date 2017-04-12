package viagogo;

//import java.awt.List;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args){
		Point uPos = new Point();
		
		System.out.println("Please enter a coordinate: ");
		ArrayList<Point> list = new ArrayList<Point>(genLoc());
		Scanner uIn = new Scanner(System.in);
		String coordinates = uIn.nextLine();
		System.out.print(coordinates);
		int commaLoc = coordinates.indexOf(",");
		uPos.x = Integer.parseInt(coordinates.substring(0,commaLoc));
		uPos.y = Integer.parseInt(coordinates.substring(commaLoc + 2));
		System.out.print(uPos);
		for(int i : list.toArray().le){
			int dist = (int) Point2D.distance(uPos.getX(), uPos.getY(), list.get(i).getX(), list.get(i).getY());
			System.out.println(dist + " " + uPos + " " + list.get(i));
		}
	}
	
	public static ArrayList<Point> genLoc() {
		Set<Point> set = new HashSet<Point>();
		Random position = new Random();
		Point test;
		
		int number = 10;

		for(int i = 0; i < 20; i++){
		    test = new Point();
		    test.x=position.nextInt(21) - 10;
		    test.y=position.nextInt(21) - 10;
		    set.add(test);     
		}

		ArrayList<Point> list = new ArrayList<Point>(set);
		return(list);
	}
}
